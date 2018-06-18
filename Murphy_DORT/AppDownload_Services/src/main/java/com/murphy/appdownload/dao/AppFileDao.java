//package com.murphy.appdownload.dao;
//
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.murphy.appdownload.dto.AppFileDto;
//import com.murphy.appdownload.dto.FileVersionDto;
//import com.murphy.appdownload.dto.ResponseMessage;
//import com.murphy.appdownload.entity.AppFileDo;
//import com.murphy.appdownload.exception.ExecutionFault;
//import com.murphy.appdownload.util.DowntimeServicesUtil;
//import com.murphy.appdownload.util.ServicesUtil;
//
//@Repository("AppFileDao")
//@Transactional("sessionFactoryTransactionManagerHana")
//public class AppFileDao {
//	
//	@Autowired
//	@Qualifier("sessionFactoryHana")
//	private SessionFactory sessionFactoryHana;
//	
//	public Session getSession() {
//		try {
//			DowntimeServicesUtil.unSetupSOCKS();
//		} catch (Exception e) {
//			System.err.println("[Murphy][AppFileDao][getSession][Socks Exception] "+e.getMessage());
//		}
//		try {
//			return sessionFactoryHana.getCurrentSession();
//		} catch (HibernateException e){
//			System.err.println("[Murphy][AppFileDao][getSession][Exception] "+e.getMessage());
//			return sessionFactoryHana.openSession();
//		}
//	}
//
//	protected AppFileDo importDto(AppFileDto fromDto) {
//		AppFileDo entity = new AppFileDo();
//		entity.setFileName(fromDto.getFileName());
//		entity.setFileType(fromDto.getFileType());
//		entity.setFileUrl(fromDto.getFileUrl());
//		entity.setFileVersion(fromDto.getFileVersion());
//		entity.setFile(fromDto.getFile());
//		entity.setApplication(fromDto.getApplication());
//		return entity;
//	}
//
//	protected AppFileDto exportDto(AppFileDo entity) {
//		AppFileDto dto = new AppFileDto();
//		dto.setFileName(entity.getFileName());
//		dto.setFileType(entity.getFileType());
//		dto.setFileUrl(entity.getFileUrl());
//		dto.setFileVersion(entity.getFileVersion());
//		dto.setFile(entity.getFile());
//		dto.setApplication(entity.getApplication());
//		return dto;
//	}
//
//	public ResponseMessage insertFile(AppFileDto dto) throws ExecutionFault {
//
//		ResponseMessage responseMessage = new ResponseMessage();
//		responseMessage.setMessage("Failed to Save File");
//		responseMessage.setStatus("FAILURE");
//		responseMessage.setStatusCode("1");
//		
//		if(!ServicesUtil.isEmpty(dto)) {
//			this.getSession().persist(importDto(dto));
//			responseMessage.setMessage("Sucessfully Inserted File");
//			responseMessage.setStatus("SUCCESS");
//			responseMessage.setStatusCode("0");
//		}
//		
//		return responseMessage;
//	}
//
//	public AppFileDto getFile(String fileType, String fileVersion, String application) {
//		FileVersionDto versionDto = this.getVersionList(fileType, fileVersion, application);
//		Query query = getSession().createQuery(
//				"from AppFileDo where fileType = :fileType and fileVersion = :fileVersion and application = :application");
//		query.setParameter("fileType", fileType);
//		query.setParameter("application", application);
//		query.setParameter("fileVersion", versionDto.getFileVersion());
//		return exportDto((AppFileDo) query.uniqueResult());
//	}
//
//	@SuppressWarnings({ "unchecked" })
//	public FileVersionDto getVersionList(String fileType, String fileVersion, String application) {
//		FileVersionDto versionDto = new FileVersionDto();
//		List<Object[]> result = getSession().createSQLQuery(
//				"SELECT FILE_TYPE AS FILE_TYPE, MAX(FILE_VERSION) AS VERSION FROM APP_FILE WHERE APPLICATION = '"
//						+ application + "' AND FILE_TYPE = '" + fileType + "' GROUP BY(FILE_TYPE)")
//				.list();
//		if (!ServicesUtil.isEmpty(result)) {
//			for (Object[] obj : result) {
//				versionDto.setFileType((String) obj[0]);
//				versionDto.setFileVersion((String) obj[1]);
//				versionDto.setApplication(application);
//			}
//		}
//		return versionDto;
//	}
//}
