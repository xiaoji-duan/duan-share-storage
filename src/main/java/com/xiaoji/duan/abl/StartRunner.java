package com.xiaoji.duan.abl;

import com.xiaoji.duan.abl.dao.StorageSpaceMapper;
import com.xiaoji.duan.abl.model.AblStorageSpace;
import com.xiaoji.duan.abl.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@Order(value=1)
public class StartRunner implements ApplicationRunner {

	@Autowired
	private DatabaseService databaseService;
	@Autowired
	private StorageSpaceMapper spaceMapper;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("Database init ...");
		this.databaseService.initDatabase();
		System.out.println("Database init ...success");
//		System.out.println("mount init...");
//		AblStorageSpace storageSpace=new AblStorageSpace();
//		storageSpace.setDel(false);
//		storageSpace.setUsed(true);
//		storageSpace.setMemoryType("文件存储");
//		List<AblStorageSpace> storageSpaces=spaceMapper.selectSpace(storageSpace);
//		Runtime runtime=Runtime.getRuntime();
//		for (AblStorageSpace space:storageSpaces) {
//			File file=new File(space.getLocalPath());
//			if (!file.exists()){
//				System.out.println("file init...");
//				file.mkdirs();
//			}
//			String execOrder="mount -t cifs";
//			String username=space.getUsername();
//			String password=space.getPassword();
//			if (username!=null&&!"".equals(username)&&password!=null&&!"".equals(password)){
//				execOrder=execOrder+"-o username="+username+",password="+password;
//			}
////			execOrder=execOrder+" "+space.getSpacePath()+" "+space.getLocalPath();
////			String[] commands={execOrder,"       "};
////			runtime.exec(commands);
//			System.out.println("mount success:"+execOrder);
//		}
	}

}
