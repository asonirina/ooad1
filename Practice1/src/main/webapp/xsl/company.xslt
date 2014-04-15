<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <body>
                <h1>Person's Company Registration</h1>
                <form method="POST" action="Registration">
                    <input type="hidden" name="current" value="2"/>
                    <input type="hidden" name="action" value="aPersonal"/>

                    <xsl:apply-templates select="contacts/contact"/>

                    Company: <input type="text" size="20" name="company"/>
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
    </xsl:template>
</xsl:stylesheet>