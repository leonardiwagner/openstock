google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);




function drawChart() {
  // Create and populate the data table.
 var data = google.visualization.arrayToDataTable([
        ['Year', 'MSFT', 'APPL', 'GOOG', 'GPRO', 'YHOO'],
        ['25/5',  1.0, 1.3, 0.8, 1.1, 1.8],
        ['26/5',   2.3, 0.3, -0.8, 0.2, -1],
        ['27/5',   -0.3, -0.8, 0.2, 0.1, 2.3],
        ['28/5',  0.5, -1.3, -0.8, 1.7, 2.8],
        ['29/5',  0.5, -1.3, -0.8, 1.7, 2.8]
      ]);

var options = {
    "chartArea.left": "100px",
    title: 'Top Markers',
    axisTitlesPosition: 'none',
    textStyle: {
      fontName: 'Times-Roman',
      fontSize: 18,
      bold: true,
      italic: true,
      color: '#871b47',     // The color of the text.
      auraColor: '#d799ae', // The color of the text outline.
      opacity: 0.8          // The transparency of the text.
    }
  };

  var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, options);

}