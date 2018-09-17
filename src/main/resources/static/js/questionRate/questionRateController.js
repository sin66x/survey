const QuestionRateChart = (function (window) {

    const questionCanvasId = "question-rate"

    var generate = function (data) {

        var ctx = document.getElementById(questionCanvasId).getContext('2d');


        // generate dataset from models


        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
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

(function ($, QuestionRateChart) {

    $(function () {

        console.log(typeof null);

        const request = $.ajax({
            url: '/question-rate'
        });

        request.done(function (response) {

            var result = [];

            $.each(response, function (index, item) {
                result.push(item.average);
            });

            QuestionRateChart.generate(result);

        });

        request.fail(function (response) {
            console.log(response)
        })

    });

})(window.jQuery, QuestionRateChart);
