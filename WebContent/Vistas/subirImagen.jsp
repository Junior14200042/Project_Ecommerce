<%@ page import ="java.util.*" %>;
<%@ page import ="org.apache.commons.fileupload.*" %>;
<%@ page import ="org.apache.commons.fileupload.disk.*" %>;
<%@ page import ="org.apache.commons.fileupload.servlet.*" %>;
<%@ page import ="org.apache.commons.io.*" %>;
<%@ page import ="java.io.*" %>;

<%
	FileItemFactory file_factory=new DiskFileItemFactory();
	ServletFileUpload servlet_up= new ServletFileUpload(file_factory);
	List items =servlet_up.parseRequest(request);
	String img="";
	for(int i=0;i<items.size();i++){
		FileItem item=(FileItem)items.get(i);
		if(!item.isFormField()){
			File fullfile=new File(item.getName());
			File archivo_server=new File("C:\\Users\\Jhunior\\eclipse-workspace\\Ecommerce_products\\WebContent\\img",fullfile.getName());
			System.out.print(archivo_server);
			item.write(archivo_server);
			img=fullfile.getName();
		}
	}
%>
<jsp:forward page="registrarProducto2.jsp">
	<jsp:param value="<%=img %>" name="img"/>
</jsp:forward>