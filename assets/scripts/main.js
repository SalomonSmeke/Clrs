"use strict";

var load = function(){
  //bindFunctionsToDom
}

var update = function(arg){
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
