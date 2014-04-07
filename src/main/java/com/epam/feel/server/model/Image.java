package com.epam.feel.server.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity for Images table.
 * 
 * @author Michael_Silvanovich
 */
@Entity (name = "Image")
@Table (name = "image")
@NamedQueries ({@NamedQuery (name = Image.QUERY_DELETE_UNUSED, query = "DELETE FROM Image im WHERE not exists(SELECT md FROM MenuDetails md WHERE md.imageId = im.id) and (im.date < :date)")})
public class Image extends BaseEntityImpl {

    private static final long serialVersionUID = 6928653105791250452L;

    public static final String QUERY_DELETE_UNUSED = "queryDeleteUnusedImages";
    public static final String PARAM_LIST_ID = "list_id";

    @Id
    @SequenceGenerator (name = "images_gen", sequenceName = "image_seq")
    @GeneratedValue (generator = "images_gen", strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "create_date")
    private Date date;

    @Column (name = "content")
    private byte[] content;

    public Image() {
        this.date = new Date();
    }

    public Image(Long id, Date date, byte[] content) {
        this.id = id;
        this.content = content;
        setDate(date);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}
