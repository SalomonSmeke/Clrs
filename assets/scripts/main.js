"use strict";
var generator
var dualGenerator

var load = function(){
  generator = new LWGenPallete()
  generator.setSteps(5)
  generator.setStrength(90)
  dualGenerator = new LWGenBridge()
  //bindFunctionsToDom
}

var update = function(arg){
  //values should update before this.
  switch (arg) {
    case "linear":
      generator.linear;
      data = generator.getGenerated;
      break;
    case "linearr":
      generator.linear;
      data = generator.getGenerated;
      break;
    case "distill":
      generator.linear;
      data = generator.getGenerated;
      break;
    case "distillr":
      generator.linear;
      data = generator.getGenerated;
      break;
    case "shade":
      generator.linear;
      data = generator.getGenerated;
      break;
    case "shader":
      generator.linear;
      data = generator.getGenerated;
      break;
  }
  d3.select("#algContainer").selectAll("div").style("background-color", function(d, i) {
    return data[i];
  });
}

function runEventLoop(loop){
  var f;
  for (f in loop) {
    loop[f].name(loop[f].arg);
  }
}

var loadLoop = [{name:update,arg:"Linear"},{name:load,arg:""}];
var data = ["#fe4365","#cb4365","#984365","#654365","#324365"];


$(document).ready(runEventLoop(loadLoop));
