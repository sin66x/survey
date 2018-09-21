const PartRateChart = (function (window) {

    const questionCanvasId = "part-rate";

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
            labels.push(item.partTitle);
            sanitizeData.push(item.average);

        });


        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: '# of Part Rate',
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

(function ($, PartRateChart) {

    $(function () {

        const request = $.ajax({
            url: '/part-rate'
        });

        request.done(function (response) {

            var result = [];

            $.each(response, function (index, partRate) {
                result.push(partRate);
            });

            PartRateChart.generate(result);

        });

        request.fail(function (response) {
            console.log(response)
        })

    });

})(window.jQuery, PartRateChart);
