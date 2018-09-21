const QuestionEngagementChart = (function (window) {

    const questionCanvasId = "question-engagement";

    var getRandomColor = function () {

        var colors = [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
        ];

        var borders = [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
        ];

        var randomNumber = Math.floor(Math.random() * 5);

        return {
            color: colors[randomNumber],
            border: borders[randomNumber]
        };

    };


    var generate = function (data) {

        var ctx = document.getElementById(questionCanvasId).getContext('2d');


        var labels = [];
        var backgroundColor = [];
        var borderColor = [];
        var sanitizeData = [];

        data.forEach(function (item) {

            var colorObject = getRandomColor();

            backgroundColor.push(colorObject.color);
            borderColor.push(colorObject.border);
            labels.push(item.type);
            sanitizeData.push(item.percentage);

        });


        var myChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: '# of Votes',
                    data: sanitizeData,
                    backgroundColor: backgroundColor,
                    borderColor: borderColor,
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


(function ($, QuestionEngagementChart) {


    const request = $.ajax({
        url: '/question-engagement'
    });


    request.done(function (response) {

        var result = [];

        $.each(response, function (index, item) {
            console.log(item);
            result.push(item);
        });

        QuestionEngagementChart.generate(result);

    })


})(window.jQuery, QuestionEngagementChart);
