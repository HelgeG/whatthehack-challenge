<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Look for a nice place for a drink</title>
    <style>
        body {
            background: #C0CCD7;
            font-family: Lato, sans-serif;
        }

        .container {
            max-width: 450px;
        }

        .row {
            position: relative;
            margin-top: 32px;
        }

        .top--container {
            background: #fff;
            width: calc(100% - 32px);
            margin-left: 32px;
            border-radius: 4px;
            box-shadow: -5px 5px 50px rgba(0, 0, 0, 0.12), -10px 10px 30px rgba(0, 0, 0, 0.2);
        }

        .top {
            padding: 32px;
        }

        .top--text {
            color: rgba(0, 0, 0, 0.54);
            font-size: 18px;
        }

        .btn-times {
            -webkit-transition: .3s;
            transition: .3s;
            font-size: 24px;
            margin-bottom: 32px;
        }
        .btn-times:hover {
            color: rgba(0, 0, 0, 0.54);
        }

        .bottom--container {
            position: absolute;
            background: #3B5368;
            width: calc(100% - 32px);
            height: calc(100% + 48px);
            margin-top: 32px;
            margin-right: 32px;
            top: 0;
            z-index: -100;
            border-radius: 4px;
            box-shadow: -5px 5px 50px rgba(0, 0, 0, 0.12), -10px 10px 30px rgba(0, 0, 0, 0.2);
            margin-bottom: 32px;
        }

        .bottom {
            padding: 32px;
            margin-top: 64px;
        }

        .btn-fab {
            position: absolute;
            right: -32px;
            bottom: 18px;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
            -webkit-transition: .3s;
            transition: .3s;
        }

        #submit {
            background-color: #bbb;
            padding: .5em;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 6px;
            color: #fff;
            /*font-family: 'Oswald';*/
            font-size: 20px;
            text-decoration: none;
            border: none;
        }

        #submit:hover {
            border: none;
            background: orange;
            box-shadow: 0px 0px 1px #777;
        }

    </style>
</head>
<body>

<div class="container">
    <div class="row">

        <div class="top--container">
            <div class="top">
                <i class="fa fa-times btn-times"></i>
                <img src="https://d13yacurqjgara.cloudfront.net/users/220725/screenshots/2364712/funnybeer_1x.jpg" alt="" class="img-responsive" />
                <h2 class="text-center">I found a nice bar for you</h2>
                <p class="text-center top--text">The highest rated bar in the vicinity that is open, is:<br><br>
                ${name}<br><br>${address}</p>
            </div>
        </div>

        <div class="bottom--container">
            <div class="bottom">
                <form action="/beer" method="get" enctype="multipart/form-data">
                    <#--<input type="hidden" id="lat" name="lat" value="" />-->
                    <#--<input type="hidden" id="long" name="long" value="" />-->
                    <button class="btn-fab" id="submit">Show me &rarr;</button>
                </form>

            </div>
        </div>

    </div>

</div>

</body>

</html>

<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
    <#--<meta charset="utf-8">-->
    <#--<title>Found a nice place for a drink</title>-->
    <#--<link rel="stylesheet" href="style.css">-->
    <#--<script src="script.js"></script>-->
<#--</head>-->
<#--<body>-->
<#--<h1>The highest rated open bar in the vicinity is ${name}</h1>-->
<#--</body>-->
<#--</html>-->