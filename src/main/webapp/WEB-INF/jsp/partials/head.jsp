<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
      integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<style>
    /* CSS used here will be applied after bootstrap.css */
    .closeBtn:focus {
        outline: none;
    }

    .close {
        color: gray;
    }

    .wrapper {
        position: relative;
        margin: 0 auto;
        overflow: hidden;
        padding: 5px;
        height: 50px;
    }

    .list {
        position: absolute;
        left: 0px;
        top: 0px;
        min-width: 3500px;

        margin-top: 0px;
    }

    .list li {
        display: table-cell;
        position: relative;
        text-align: center;
        cursor: grab;
        cursor: -webkit-grab;
        color: #efefef;
        vertical-align: middle;
    }

    .scroller {
        text-align: center;
        cursor: pointer;
        display: none;
        padding: 11px 7px 7px;
        white-space: no-wrap;
        vertical-align: middle;
    }

    .scroller-right {
        float: right;
    }

    .scroller-left {
        float: left;
    }
</style>

<title><%= request.getParameter("title") %></title>
