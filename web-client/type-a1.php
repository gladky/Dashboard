<div>
<?php 
echo '
<div class="example-plot" id="' . $name . '" style="width: ' . $width .'px; height: ' . $height .'px;"></div>
';
  ?>
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

		$request = "gladky#". $projectName ."\n";
		socket_write($socket, $request , 256);
		$string = socket_read($socket, 1256, PHP_NORMAL_READ);
		
		

		//echo 'document.write("Hello World!");';
		echo "var line3 = ". $string . ";\n";
		?>

	
	
    $.jqplot.config.enablePlugins = true;

    
    var plot1 = $.jqplot('<?php echo $name; ?>', [line3], {
		title:'<?php echo $projectName;?>',
        axes:{
            xaxis:{
                renderer:$.jqplot.DateAxisRenderer, 
                rendererOptions:{
                    tickRenderer:$.jqplot.CanvasAxisTickRenderer
                },
                tickOptions:{
                        fontSize:'8pt', 
                        fontFamily:'Tahoma', 
                        angle:7
                    }
            },
            yaxis:{
				autoscale:true,
				labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
                rendererOptions:{
                    tickRenderer:$.jqplot.CanvasAxisTickRenderer
				},
                tickOptions:{
                        fontSize:'8pt', 
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


</div>
