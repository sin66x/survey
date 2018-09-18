const QuestionEngagementChart = (function (window) {

    const questionCanvasId = "question-engagement";

    var generate = function (data) {

        var ctx = document.getElementById(questionCanvasId).getContext('2d');


        var labelColors = [
                "Red", "Blue", "Yellow", "Green", "Purple", "Orange"
            ],
            labels = [];

        for (var i = 0; i < data.length; i++) {
            var randomNumber = Math.floor(Math.random() * 5);
            var color = labelColors[randomNumber];
            labels.push(color);
        }

        var myChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: '# of Votes',
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }

        });

    };


    return {
        generate: generate
    }

})(window);



(function ($ , QuestionEngagementChart) {


    const request = $.ajax({
        url: '/question-engagement'
    })


    request.done(function (response) {
        var result = [];
        $.each(response, function (index, item) {

            var engagement = item.percentage;
            /*var engagement = {
                percentage: item.percentage,
                type: item.type
            }*/

            result.push(engagement);

            QuestionEngagementChart.generate(result);

        })
    })


})(window.jQuery, QuestionEngagementChart)
