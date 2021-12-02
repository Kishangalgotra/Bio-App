package CommonFiles;

public interface Htmltemplates {

    String template = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "  <head>\n" +
            "   <style>\n" +
            "    body {\n" +
            "        height: auto;\n" +
            "        width: 595px;\n" +
            "        /* to centre page on screen*/\n" +
            "        margin-left: auto;\n" +
            "        margin-right: auto;\n" +
            "    }\n" +
            "\t\n" +
            "\thead{\n" +
            "\t\tpadding-top: 30px; \n" +
            "\t}\n" +
            "\t\n" +
            "\t.HD {\n" +
            "\t    height: 70px;\n" +
            "        background-color: #FF0000;\n" +
            "\t\tcolor :white;\n" +
            "\t\tpadding-top: 30px;  \n" +
            "\t\tpadding-right: 20px;  \n" +
            "\t\ttext-align : right;\n" +
            "    }\n" +
            "\t.event-detail {\n" +
            "        background-color: #EBEBEB;\n" +
            "\t\ttext-align: left;\n" +
            "    }\n" +
            "\t.HDas {\n" +
            "\t    height: 200px;\n" +
            "        margin: 20px;\n" +
            "        border: 5px solid;\n" +
            "        background-color: #EBEBEB;\n" +
            "    }\n" +
            "\tP {\n" +
            "\t  width: 100%; //or whatever looks best\n" +
            "\t  margin: auto; //top and bottom margin can be added for aesthetic effect\n" +
            "\t}\n" +
            "    </style>\n" +
            "  </head>\n" +
            "   <body >\n" +
            "\t  <div class=\"event-detail\">\n" +
            "\t\t<h2 class=\"HD\" >Name</h2>\n" +
            "\t\t<h2>This is the acknowledgement of your registeration for attending the\n" +
            "\t\t\tevent.</h2>\n" +
            "\t\t<p class=\"row\">\n" +
            "\t\t\tEvent Name:<br />Machine learning introduction for kids\n" +
            "\t\t</p>\n" +
            "\t\t<p class=\"row\">\n" +
            "\t\t\tEvent Date:<br />27 May 2021\n" +
            "\t\t</p>\n" +
            "\t\t<p class=\"row\">\n" +
            "\t\t\tTime:<br />10:30 AM\n" +
            "\t\t</p>\n" +
            "\t\t<p class=\"row\">\n" +
            "\t\t\tVenue:<br />AMC Graduate Center,<br>25, AMC Street,<br>New York, USA.\n" +
            "\t\t</p>\n" +
            "\t\t<p class=\"pdf-content\">\n" +
            "\t\t\tCoadddss our <a href=\"#\">Organizers' Team</a> if you need any support.\n" +
            "\t\t</p>\n" +
            "\t</div>\n" +
            "\n" +
            "  </body>\n" +
            "</html>\n" +
            "\n";
}
