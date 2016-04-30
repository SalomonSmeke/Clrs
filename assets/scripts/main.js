"use strict";

var load = function(){

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
var data = ["#FFF","#AAA","#FFF","#666","#FFF"];

$(document).ready(runEventLoop(loadLoop));
