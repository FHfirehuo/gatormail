<%@ page import="edu.ufl.osg.webmail.util.Util,
                 edu.ufl.osg.webmail.User,
                 edu.ufl.osg.webmail.prefs.PreferencesProvider,
                 edu.ufl.osg.webmail.Constants,
                 java.util.Properties"%>
<%@page contentType="text/html"%>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@taglib uri="/tags/struts-bean" prefix="bean"%>
<%
    final User user = Util.getUser(session);
    Properties prefs = null;
    boolean hideHeader = false;
    if (user != null) {
        PreferencesProvider pp = (PreferencesProvider)application.getAttribute(Constants.PREFERENCES_PROVIDER);
        prefs = pp.getPreferences(user, session);
        hideHeader = Boolean.valueOf(prefs.getProperty("view.header.hide", "false")).booleanValue();
    }
    if (!hideHeader) {
%>
<table class="header" width="100%" height="91" border="0" cellpadding="0" cellspacing="0">
 <tr>
  <td rowspan="2" valign="middle" align="right"><html:img page="/images/spacer.gif" width="3" height="16" border="0"/></td>

  <td width="180" rowspan="2"><html:link forward="inbox"><html:img page="/images/logo.png" width="180" height="91" border="0"/></html:link></td>

  <td height="75" valign="bottom" class="version">v<%= prefs.getProperty("project.version", "DEVELOPMENT") %></td>
  <td rowspan="2" height="75" width="100%" valign="bottom" class="alertMessage" id="headerAlertMessage">
      <script type="text/javascript" src="alertMessage.js"></script>
      &nbsp;
  </td>

  <td rowspan="2" valign="middle" align="right">
   <table border="0" cellpadding="2">
<%
    if (prefs != null) {
        final String username = user.getUsername();
        final String displayName = prefs.getProperty("user.name");
%>
    <tr>
     <td align="center" valign="middle">
      <bean:message key="common.currentUser" arg0="<%= username %>" arg1="<%= displayName %>"/>
     </td>
    </tr>
<%
    }
%>
   </table>
  </td>

  <td rowspan="2" valign="middle" align="right"><html:img page="/images/spacer.gif" width="3" height="16" border="0"/></td>
 </tr>
 <tr>
  <td height="16"><html:img page="/images/spacer.gif" width="30" height="16" border="0"/></td>
 </tr>
</table>
<%
    }
%>
