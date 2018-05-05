package com.tolunayguduk.dao.interfaces;

import com.tolunayguduk.model.File;

public interface FileDAO {
    public void insertFile(File file);
    public Boolean deleteFile(File file);
    public Boolean renameFile(File file, String newName);
}
