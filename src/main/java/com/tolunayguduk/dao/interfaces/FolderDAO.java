package com.tolunayguduk.dao.interfaces;

import com.tolunayguduk.model.Folder;
import java.util.List;

public interface FolderDAO {
    public void insertFolder(Folder folder);
    public List<Folder> isExistFolder(String folderName);
    public List<Folder> isExistFolderByOwner(Long ownerID);
    public Boolean deleteFolder(Folder folder);
    public Boolean renameFolder(Folder folder, String newName);
}
