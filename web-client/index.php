<!DOCTYPE html>

<html>
<head>

    <title>Dashboard</title>
    <link class="include" rel="stylesheet" type="text/css" href="jquery.jqplot.min.css" />
  
    <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="../excanvas.js"></script><![endif]-->
    <script class="include" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>

<div class="example-plot" id="chart" style="width: 600px; height: 400px;"></div>
  
<!-- Example scripts go here -->

<style type="text/css">
    .jqplot-target: {
        margin-left: 70px;
    }
</style>

<script type="text/javascript" class="code">
  
$(document).ready(function(){
    // Enable plugins like highlighter and cursor by default.
    // Otherwise, must specify show: true option for those plugins.
	
	
<?php

		$address = "localhost";  
		$port = "6789";   
		$socket = socket_create(AF_INET, SOCK_STREAM, getprotobyname('tcp'));
		socket_connect($socket, $address, $port);
		$greetings = socket_read($socket, 256, PHP_NORMAL_READ);
		socket_write($socket, "gladky#NASK\n", 256);
		$string = socket_read($socket, 256, PHP_NORMAL_READ);
		
		

		//echo 'document.write("Hello World!");';
		echo "var line3 = ". $string . ";\n";
		?>

	
	
    $.jqplot.config.enablePlugins = true;

    var line1=[['2008-09-30', 4], ['2008-10-30', 6.5], ['2008-11-30', -5.7], ['2008-12-30', 9], 
    ['2009-01-30', 8.2], ['2009-02-28', -7.6], ['2009-03-30', -11.4], ['2009-04-30', 16.2], 
    ['2009-05-30', 21.8], ['2009-06-30', 119.3], ['2009-07-30', 29.7], ['2009-08-30', 36.7], 
    ['2009-09-30', 38.7], ['2009-10-30', 33.7], ['2009-11-30', -49.7], ['2009-12-30', 62.7]];
    
    var plot1 = $.jqplot('chart', [line3], {
        title:'Naukowa i Akademicka Siec Komputerowa',
        axes:{
            xaxis:{
                renderer:$.jqplot.DateAxisRenderer, 
                rendererOptions:{
                    tickRenderer:$.jqplot.CanvasAxisTickRenderer
                },
                tickOptions:{ 
                    fontSize:'10pt', 
                    fontFamily:'Tahoma', 
                    angle:-40
                }
            },
            yaxis:{
				autoscale:true,
				labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
                rendererOptions:{
                    tickRenderer:$.jqplot.CanvasAxisTickRenderer
				},
                tickOptions:{
                        fontSize:'10pt', 
                        fontFamily:'Tahoma', 
                        angle:0
                    }
            }
        },
        series:[{ lineWidth:4, markerOptions:{ style:'square' } }],
        cursor:{
            zoom:true,
            looseZoom: true
        }
    });

});
</script>


<!-- End example scripts -->

<!-- Don't touch this! -->


    <script class="include" type="text/javascript" src="jquery.jqplot.min.js"></script>
    <script type="text/javascript" src="syntaxhighlighter/scripts/shCore.min.js"></script>
    <script type="text/javascript" src="syntaxhighlighter/scripts/shBrushJScript.min.js"></script>
    <script type="text/javascript" src="syntaxhighlighter/scripts/shBrushXml.min.js"></script>
<!-- End Don't touch this! -->

<!-- Additional plugins go here -->

    <!-- to render rotated axis ticks, include both the canvasText and canvasAxisTick renderers -->
    <script language="javascript" type="text/javascript" src="plugins/jqplot.canvasTextRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="plugins/jqplot.dateAxisRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="plugins/jqplot.cursor.min.js"></script>

<!-- End additional plugins -->


</body>


</html>
