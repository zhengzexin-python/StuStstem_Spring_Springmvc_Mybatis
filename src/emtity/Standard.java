package emtity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by 25397 on 2016/12/22.
 */
public class Standard implements Serializable{
    private int id;
    private String std_num;
    private String zhname;
    private String version;
    private String skeys;
    private Date release_date;
    private Date impl_date;
    private String package_path;

    public Standard() {
    }

    public Standard(int id, String std_num, String zhname, String version, String skeys, Date release_date, Date impl_date, String package_path) {
        this.id = id;
        this.std_num = std_num;
        this.zhname = zhname;
        this.version = version;
        this.skeys = skeys;
        this.release_date = release_date;
        this.impl_date = impl_date;
        this.package_path = package_path;
    }

    public Standard(String std_num, String zhname, String version, String skeys, Date release_date, Date impl_date, String package_path) {
        this.std_num = std_num;
        this.zhname = zhname;
        this.version = version;
        this.skeys = skeys;
        this.release_date = release_date;
        this.impl_date = impl_date;
        this.package_path = package_path;
    }

    public Standard(int id, String std_num, String zhname, String version, String skeys, Date release_date, Date impl_date) {
        this.id = id;
        this.std_num = std_num;
        this.zhname = zhname;
        this.version = version;
        this.skeys = skeys;
        this.release_date = release_date;
        this.impl_date = impl_date;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "id=" + id +
                ", std_num='" + std_num + '\'' +
                ", zhname='" + zhname + '\'' +
                ", version='" + version + '\'' +
                ", skeys='" + skeys + '\'' +
                ", release_date=" + release_date +
                ", impl_date=" + impl_date +
                ", package_path='" + package_path + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStd_num() {
        return std_num;
    }

    public void setStd_num(String std_num) {
        this.std_num = std_num;
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSkeys() {
        return skeys;
    }

    public void setSkeys(String skeys) {
        this.skeys = skeys;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Date getImpl_date() {
        return impl_date;
    }

    public void setImpl_date(Date impl_date) {
        this.impl_date = impl_date;
    }

    public String getPackage_path() {
        return package_path;
    }

    public void setPackage_path(String package_path) {
        this.package_path = package_path;
    }
}
