package com.tolunayguduk.service.classes;

import com.tolunayguduk.dao.interfaces.FileDAO;
import com.tolunayguduk.dao.interfaces.FolderDAO;
import com.tolunayguduk.model.File;
import com.tolunayguduk.model.Folder;
import com.tolunayguduk.service.interfaces.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false,
        rollbackFor = Exception.class)
public class FileServiceImpl implements FileService {
    @Autowired
    FileDAO fileDAO;
    @Override
    public void insertFile(File file) {
        fileDAO.insertFile(file);
    }
    @Override
    public void deleteFile(File file) {
        fileDAO.deleteFile(file);
    }


    @Override
    public void renameFile(File file, String newName) {
        fileDAO.renameFile(file,newName);
    }
}
