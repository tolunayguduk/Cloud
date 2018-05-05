package com.tolunayguduk.dao.classes;

import com.tolunayguduk.dao.interfaces.FolderDAO;
import com.tolunayguduk.model.Folder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class FolderDAOImpl implements FolderDAO {

    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void insertFolder(Folder folder) {
        Session session = getCurrentSession();

        session.saveOrUpdate(folder);
        session.flush();
    }
    @Override
    public List<Folder> isExistFolder(String folderName) {
        Session session = getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Folder.class);
        Root<Folder> root = criteriaQuery.from(Folder.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("name"), folderName)
        );
        Query query = session.createQuery(criteriaQuery);
        List<Folder> folderList = query.getResultList();

        return folderList;
    }
    @Override
    public List<Folder> isExistFolderByOwner(Long ownerID) {
        Session session = getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Folder.class);
        Root<Folder> root = criteriaQuery.from(Folder.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("ownerID"), ownerID)
        );
        Query query = session.createQuery(criteriaQuery);
        List<Folder> folderList = query.getResultList();

        return folderList;
    }
    @Override
    public Boolean deleteFolder(Folder folder) {

        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Folder> delete = criteriaBuilder.createCriteriaDelete(Folder.class);
        Root<Folder> root = delete.from(Folder.class);
        delete.where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("name"),folder.getName()),
                criteriaBuilder.equal(root.get("ownerID"),folder.getOwnerID()),
                criteriaBuilder.equal(root.get("path"),folder.getPath())
        ));
        int sonuc = session.createQuery(delete).executeUpdate();
        if(sonuc>0){ return true;}
        else return false;
    }
    @Override
    public Boolean renameFolder(Folder folder, String newName) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Folder> update = builder.createCriteriaUpdate(Folder.class);
        Root<Folder> root = update.from(Folder.class);
        Expression<Boolean> filterPredicate = builder
                .and(
                        builder.equal(root.get("name"),folder.getName()),
                        builder.equal(root.get("ownerID"),folder.getOwnerID()),
                        builder.equal(root.get("path"),folder.getPath())
                );
        update
                .set(root.get("name"), newName)
                .where(filterPredicate);
        session.createQuery(update).executeUpdate();
        return null;
    }
}
