<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <body>
                <h1>Person's Company Registration</h1>
                <form method="POST" action="Registration">
                    <input type="hidden" name="current" value="3"/>
                    <input type="hidden" name="action" value="aSave"/>

                    <xsl:apply-templates select="contacts/contact"/>

                    Hobby: <input type="text" size="20" name="hobby"/>
                    <br/>
                    <input type="submit" value="Next"/>
                </form>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="contacts/contact">
        FirstName:
        <xsl:value-of select="firstName"/>
        <br/>
        LastName:
        <xsl:value-of select="lastName"/>
        <br/>
        Company:
        <xsl:value-of select="company"/>
        <br/>
    </xsl:template>
</xsl:stylesheet>