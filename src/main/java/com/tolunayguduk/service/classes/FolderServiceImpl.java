package com.tolunayguduk.service.classes;


import com.tolunayguduk.dao.interfaces.FolderDAO;
import com.tolunayguduk.model.Folder;
import com.tolunayguduk.service.interfaces.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false,
        rollbackFor = Exception.class)
public class FolderServiceImpl implements FolderService {
    @Autowired
    FolderDAO folderdao;
    @Override
    public void insertFolder(Folder folder) {
        folderdao.insertFolder(folder);
    }
    @Override
    public void deleteFolder(Folder folder) {
        folderdao.deleteFolder(folder);
    }
    @Override
    public List<Folder> isExistFolder(String folderName) {
        return folderdao.isExistFolder(folderName);
    }
    @Override
    public List<Folder> isExistFolderByOwner(Long ownerID) {
        return folderdao.isExistFolderByOwner(ownerID);
    }


    @Override
    public void renameFolder(Folder folder, String newName) {
        folderdao.renameFolder(folder, newName);
    }
}
