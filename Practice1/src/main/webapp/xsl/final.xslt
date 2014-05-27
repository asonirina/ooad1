<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <body>
                <h1>Congratulation!</h1>
                <P>
                    Contact has been saved successfully
                </P>

                <xsl:for-each select="contacts/contact">
                    FirstName:
                    <xsl:value-of select="firstName"/>
                    <br/>
                    LastName:
                    <xsl:value-of select="lastName"/>
                    <br/>
                    Company:
                    <xsl:value-of select="company"/>
                    <br/>
                    Hobby:
                    <xsl:value-of select="hobby"/>
                    <br/>
                    <br/>
                </xsl:for-each>

                <form action="Registration">
                    <input type="hidden" name="action" value="viewContact"/>
                    <input type="submit" value="Back" name="Back"/>
                    <input type="text" name="page" value="{/contacts/page}"/>
                    <input type="submit" value="Next" name="Next"/>
                </form>

            </body>
        </html>
    </xsl:template>


</xsl:stylesheet>