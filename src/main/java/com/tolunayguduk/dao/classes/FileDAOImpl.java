package com.tolunayguduk.dao.classes;

import com.tolunayguduk.dao.interfaces.FileDAO;
import com.tolunayguduk.model.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;

@Repository
public class FileDAOImpl implements FileDAO {

    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void insertFile(File file) {
        Session session = getCurrentSession();
        session.saveOrUpdate(file);
        session.flush();
    }
    @Override
    public Boolean deleteFile(File file) {
        Session session = getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<File> delete = criteriaBuilder.createCriteriaDelete(File.class);
        Root<File> root = delete.from(File.class);
        delete.where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("name"),file.getName()),
                criteriaBuilder.equal(root.get("ownerID"),file.getOwnerID()),
                criteriaBuilder.equal(root.get("path"),file.getPath())
        ));
        int sonuc = session.createQuery(delete).executeUpdate();
        if(sonuc>0){ return true;}
        else return false;
    }
    @Override
    public Boolean renameFile(File file, String newName) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<File> update = builder.createCriteriaUpdate(File.class);
        Root<File> root = update.from(File.class);
        Expression<Boolean> filterPredicate = builder
                .and(
                        builder.equal(root.get("name"),file.getName()),
                        builder.equal(root.get("ownerID"),file.getOwnerID()),
                        builder.equal(root.get("path"),file.getPath())
                );
        update
                .set(root.get("name"), newName)
                .where(filterPredicate);
        session.createQuery(update).executeUpdate();
        return null;
    }
}
