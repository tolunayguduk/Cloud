package com.tolunayguduk.service.interfaces;

import com.tolunayguduk.model.File;

public interface FileService {
    public void insertFile(File file);
    public void deleteFile(File file);
    public void renameFile(File file, String newName);
}
