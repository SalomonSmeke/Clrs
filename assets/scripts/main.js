"use strict";

var generator;
var dualGenerator;
var curr, data;
var lo = "194365";
var hi = "fe4365";

var load = function(){
  generator = new LWGenPallete();
  generator.setSteps(5);
  generator.setStrength(90);
  dualGenerator = new LWGenBridge();
  $(".ch").submit(function(e){
    e.preventDefault();
    letsDoIt(true);
  });
  $(".cl").submit(function(e){
    e.preventDefault();
    letsDoIt(false);
  });
}

var update = function(arg){
  curr = arg;
  generator.setBaseS(hi);
  dualGenerator.setBasesBridge([hi,lo]);
  switch (arg) {
    case "linear":
      generator.linear();
      data = generator.getGenerated();
      break;
    case "linearr":
      generator.setBaseS(lo);
      generator.linearR();
      data = generator.getGenerated();
      break;
    case "distill":
      generator.distill();
      data = generator.getGenerated();
      break;
    case "distillr":
      generator.setBaseS(lo);
      generator.distillR();
      data = generator.getGenerated();
      break;
    case "shade":
      generator.shade();
      data = generator.getGenerated();
      break;
    case "shader":
      generator.setBaseS(lo);
      generator.shadeR();
      data = generator.getGenerated();
      break;
    case "bridge":
      dualGenerator.bridge();
      data = dualGenerator.getGeneratedBridge();
  }
  d3.select("#algContainer").selectAll("div").style("background-color", function(d, i) {
    return "#"+data[i];
  });
  document.getElementById("colorHigh").value = "#" + data[0];
  console.log(data);
  document.getElementById("colorLow").value = "#" + data[4];
}

function runEventLoop(loop){
  var f;
  for (f in loop) {
    loop[f].name(loop[f].arg);
  }
}

var letsDoIt = function (arg){
  hi = document.getElementById("colorHigh").value;
  while (hi.length>6){
    hi = hi.substring(1,hi.length)
  }
  lo = document.getElementById("colorLow").value;
  while (lo.length>6){
    lo = lo.substring(1,lo.length)
  }
  if (curr != "bridge"){
    if (!arg){
      curr = curr+"r"
    }
  }
  update(curr);
}

var change = function (arg){
  update(arg);
}

var loadLoop = [{name:load,arg:""},{name:update,arg:"linear"}];

$(document).ready(runEventLoop(loadLoop));
