package com.tolunayguduk.service.interfaces;

import com.tolunayguduk.model.Folder;
import com.tolunayguduk.model.User;
import java.util.List;

public interface FolderService {
    public void insertFolder(Folder folder);
    public void deleteFolder(Folder folder);
    public List<Folder> isExistFolder(String folderName);
    public List<Folder> isExistFolderByOwner(Long ownerID);
    public void renameFolder(Folder folder, String newName);
}
