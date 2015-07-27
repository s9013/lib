1.<context:component-scan/>��<mvc:annotation-driven/>������

http://www.iteye.com/problems/66133

2.servlet api
3.Assembly
4.upload



#spring mvc �ļ��ϴ�
	1.����fileupload�ܰ�
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.3.1</version>
		</dependency>
	
	2.����
		<!-- �ϴ��ļ����أ���������ϴ��ļ���С 10M=10*1024*1024(B)=10485760 bytes -->
		<bean id="multipartResolver"
			class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
			<property name="maxUploadSize" value="10485760" />
			<property name="defaultEncoding" value="UTF-8" />
		</bean> 
	3.��������
		<form action="api/file/upload" method="post" enctype="multipart/form-data">
			<input type="file" name="files" multiple="multiple"/>
			<input type="submit" value="submit" />
		</form>
	4.controller
		@RequestMapping(value = "upload")
		private void upload(@RequestParam(value = "files") MultipartFile[] files) throws IllegalStateException, IOException {
			log.info("upload");
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				file.transferTo(new File("d:/test.txt"));
			}
		}