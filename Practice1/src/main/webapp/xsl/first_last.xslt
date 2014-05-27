<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <body>
                <h1>Person's Company Registration</h1>
                <form method="POST" action="Registration">
                    <input type="hidden" name="current" value="1"/>
                    <input type="hidden" name="action" value="aCompany"/>

                    FirstName: <input type="text" size="20" name="firstName"/>
                    <br/>
                    LastName: <input type="text" size="20" name="lastName"/>
                    <br/>
                    <input type="submit" value="Next"/>
                </form>
            </body>
        </html>
    </xsl:template>


</xsl:stylesheet>