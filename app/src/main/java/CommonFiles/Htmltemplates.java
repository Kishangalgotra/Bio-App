package CommonFiles;

interface HtmlTemplates {

    String template1tags = "&name&#&religion&#&statetype&#&dateofbirth&#" +
            "&state&#&height&#&profession&#&course&#&fathername&#&fatherprofession&#" +
            "&phonenumber&#&mothername&#&siblingcount&#&address&";

    String template1html = "<html>\n" +
            "<head> \n" +
            " <style>\n" +
            "   body {\n" +
            "       background-color: #EBEBEB;\n" +
            "    }\n" +
            "\thead{\t\n" +
            "\t}\n" +
            "\t.HD {\n" +
            "\t    height: 70px;\n" +
            "        background-color: #FF0000;\n" +
            "\t\tcolor :white;\n" +
            "\t\tpadding-right: 20px;  \n" +
            "\t\ttext-align : right;\n" +
            "    }\n" +
            "\t.event-detail {\n" +
            "\t    margin-left: 10px;\n" +
            "\t\ttext-align: left;\n" +
            "    }\n" +
            "\t.header{\n" +
            "\t  height: 70px;\n" +
            "        background-color: #FF0000;\n" +
            "\t\tcolor :white;\n" +
            "\t\tpadding-right: 20px;  \n" +
            "\t\ttext-align : right;\n" +
            "\t}\n" +
            "    </style>\n" +
            " <h2 class =\"header\">&name&</h2>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            " <body >\n" +
            "\t  <div class=\"event-detail\">\n" +
            "\t\t<p class=\"row\">Religions&emsp;&emsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&religion&</p>\n" +
            "\t\t<p class=\"row\">State Type&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&nbsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&statetype&</p>\n" +
            "\t\t<p class=\"row\">Date Of Birth&emsp;&emsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&dateofbirth&</p>\n" +
            "\t\t<p class=\"row\">State&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&state&</p>\n" +
            "\t\t<p class=\"row\">Height&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&height&</p>\n" +
            "\t\t<p class=\"row\">Profession&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&profession&</p>\n" +
            "\t\t<p class=\"row\">Course&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&course&</p>\n" +
            "\t\t<p class=\"row\">Father'sName&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&fathername&</p>\n" +
            "\t\t<p class=\"row\">Father's Profession&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&fatherprofession&</p>\n" +
            "\t\t<p class=\"row\">Phone Number&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&phonenumber&</p>\n" +
            "\t\t<p class=\"row\">Mother's name&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&mothername&</p>\n" +
            "\t\t<p class=\"row\">How Many Siblings&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&siblingcount&</p>\n" +
            "\t\t<p class=\"row\">Address&emsp;&emsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&address&</p>\n" +
            "\t</div>\n" +
            "  </body>\n" +
            "</body>\n" +
            "</html>\n" +
            "\n";
}
