package soexample.umeng.com.baiyu20181210.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by Shinelon on 2018/12/11.
 */
@Entity(nameInDb = "jokes")
public class JokesDao {
    @Id(autoincrement = true)
    public Long id;
    public String img;
    public String time;
    public String name;
    @Generated(hash = 2121688971)
    public JokesDao(Long id, String img, String time, String name) {
        this.id = id;
        this.img = img;
        this.time = time;
        this.name = name;
    }
    @Generated(hash = 1656222982)
    public JokesDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JokesDao{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
