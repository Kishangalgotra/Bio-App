package CommonFiles;

interface HtmlTemplates {

    String template1tags = "&name&#&religion&#&statetype&#&dateofbirth&#" +
            "&state&#&height&#&profession&#&course&#&fathername&#&fatherprofession&#" +
            "&phonenumber&#&mothername&#&siblingcount&#&address&";

    String rounhtmltemplate = "<html>\n" +
            "<head> \n" +
            "\n" +
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
            "\t\tbackground-color: #4CAF50;\n" +
            "\t\tborder: none;\n" +
            "\t\tcolor: white;\n" +
            "\t\tpadding: 15px 32px;\n" +
            "\t\ttext-align: center;\n" +
            "\t\ttext-decoration: none;\n" +
            "\t\t\n" +
            "\t\tfont-size: 40px;\n" +
            "\t\tmargin: 4px 2px;\n" +
            "\t\tcursor: pointer;\n" +
            "\t\tpadding = 40px;\n" +
            "\t\tborder-radius: 5px;\n" +
            "\t\t\n" +
            "\t}\n" +
            "\t\n" +
            "\t.subject{\n" +
            "\t\tbackground-color: #FF0000;\n" +
            "\t\tborder: none;\n" +
            "\t\tcolor: white;\n" +
            "\t\tpadding: 15px 32px;\n" +
            "\t\ttext-align: left;\n" +
            "\t\ttext-decoration: none;\n" +
            "\t\t\n" +
            "\t\tfont-size: 16px;\n" +
            "\t\tmargin: 4px 2px;\n" +
            "\t\tcursor: pointer;\n" +
            "\t\tborder-radius: 5px;\n" +
            "\t}\n" +
            "\t\n" +
            "\t.data{\n" +
            "\t\t\n" +
            "\t\tbackground-color: #4CAF50;\n" +
            "\t\tborder: none;\n" +
            "\t\tcolor: white;\n" +
            "\t\tpadding: 15px 32px;\n" +
            "\t\ttext-align: left;\n" +
            "\t\ttext-decoration: none;\n" +
            "\t\t\n" +
            "\t\tfont-size: 16px;\n" +
            "\t\tmargin: 4px 2px;\n" +
            "\t\tcursor: pointer;\n" +
            "\t\tpadding = 40px;\n" +
            "\t\tborder-radius: 5px;\n" +
            "\t}\n" +
            "\t\n" +
            "\t#rectangle{\n" +
            "\t\twidth:200px;\n" +
            "\t\theight:100px;\n" +
            "\t\tbackground:blue;\n" +
            "\t}\n" +
            "    </style>\n" +
            " <h2 class =\"header\">&name&</h2>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            " <body >\n" +
            "\t  <div class=\"event-detail\" >\n" +
            "\t  <table align =\"center\" >\n" +
            "\t\t  <tr  >\n" +
            "\t\t\t<th align=\"left\" class =\"subject\">Religion</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&religion&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">State Type:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&statetype&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Date Of Birth:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&dateofbirth&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">State:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&state&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t   <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Height:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&height&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Profession:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&profession&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Course:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&course&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Father'sName:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&fathername&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t    <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Father's Profession:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&fatherprofession&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Phone Number:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&phonenumber&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Mother's name:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&mothername&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t  <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">How Many Siblings:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&siblingcount&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t    <tr>\n" +
            "\t\t\t<th align=\"left\"  class =\"subject\">Address:</th>\n" +
            "\t\t\t<th align=\"left\" class =\"data\">&address&</th>\n" +
            "\t\t  </tr>\n" +
            "\t\t</table>\n" +
            "\n" +
            "\t</div>\n" +
            "  </body>\n" +
            "</body>\n" +
            "</html>\n" +
            "\n";
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
