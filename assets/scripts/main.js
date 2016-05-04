"use strict";

var generator;
var dualGenerator;
var curr, data;
var lo = "12fa94";
var hi = "fe4365";

var load = function(){
  generator = new LWGenPallete();
  generator.setSteps(5);
  generator.setStrength(90);
  dualGenerator = new LWGenBridge();
  dualGenerator.setStepsBridge(5);
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
      generator.linearR();
      data = generator.getGenerated();
      break;
    case "distill":
      generator.distill();
      data = generator.getGenerated();
      break;
    case "distillr":
      generator.distillR();
      data = generator.getGenerated();
      break;
    case "shade":
      generator.shade();
      data = generator.getGenerated();
      break;
    case "shader":
      generator.shadeR();
      data = generator.getGenerated();
      break;
    case "bridge":
  }
  d3.select("#algContainer").selectAll("div").style("background-color", function(d, i) {
    return "#"+data[i];
  });
}

function runEventLoop(loop){
  var f;
  for (f in loop) {
    loop[f].name(loop[f].arg);
  }
}

var letsDoIt = function (arg){
  hi = document.getElementById("colorHigh").value;
  lo = document.getElementById("colorLow").value;
  update(curr);
}

var loadLoop = [{name:load,arg:""},{name:update,arg:"linear"}];

$(document).ready(runEventLoop(loadLoop));
