package by.bsuir.userhibernate.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Date: 10.04.2019
 *
 * @author Kavzovich Anastasia
 * @version 1.0
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "userName",
        "secondName",
        "lastName",
        "phoneNum",
        "birthday",
        "gender",
        "passportSeria",
        "passportNum",
        "identicationNum",
        "passportWhoGive",
        "passportGiveDate",
        "livingCity",
        "address",
        "homePhone",
        "email",
        "citizenship"
})
@Entity
@Table(name = "userdata", schema = "test_db")
public  class User {

    @XmlElement(required = true)
    private String userName;
    @XmlElement(required = true)
    private String secondName;
    @XmlElement(required = true)
    private String lastName;
    @XmlElement(required = true)
    private String phoneNum;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    private Date birthday;
    private boolean gender;
    @XmlElement(required = true)
    private String passportSeria;
    @XmlElement(required = true)
    private String passportNum;
    private String identicationNum;
    @XmlElement(required = true)
    private String passportWhoGive;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    private Date passportGiveDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private City livingCity;
    @XmlElement(required = true)
    private String address;
    private String homePhone;
    private String email;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Citizenship citizenship;
    @XmlAttribute(name = "id", required = true)
    private int userDataId;

    @Id
    @Column(name = "UserDataId", nullable = false)
    public int getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(int userDataId) {
        this.userDataId = userDataId;
    }

    @Basic
    @Column(name = "UserName", nullable = false, length = 45)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "SecondName", nullable = false, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "LastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "PhoneNum", nullable = true, length = 13)
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "Birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Gender", nullable = false)
    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "PassportSeria", nullable = false, length = 2)
    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    @Basic
    @Column(name = "PassportNum", nullable = false, length = 10)
    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    @Basic
    @Column(name = "IdenticationNum", nullable = true, length = 13)
    public String getIdenticationNum() {
        return identicationNum;
    }

    public void setIdenticationNum(String identicationNum) {
        this.identicationNum = identicationNum;
    }

    @Basic
    @Column(name = "PassportWhoGive", nullable = false, length = -1)
    public String getPassportWhoGive() {
        return passportWhoGive;
    }

    public void setPassportWhoGive(String passportWhoGive) {
        this.passportWhoGive = passportWhoGive;
    }

    @Basic
    @Column(name = "PassportGiveDate", nullable = false)
    public Date getPassportGiveDate() {
        return passportGiveDate;
    }

    public void setPassportGiveDate(Date passportGiveDate) {
        this.passportGiveDate = passportGiveDate;
    }

    @Basic
    @Column(name = "LivingCity", nullable = true)
    @Enumerated(EnumType.STRING)
    public City getLivingCity() {
        return livingCity;
    }

    @Enumerated(EnumType.STRING)
    public void setLivingCity(City livingCity) {
        this.livingCity = livingCity;
    }

    @Basic
    @Column(name = "Address", nullable = false, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "HomePhone", nullable = true, length = 15)
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Citizenship", nullable = false)
    @Enumerated(EnumType.STRING)
    public Citizenship getCitizenship() {
        return citizenship;
    }
    @Enumerated(EnumType.STRING)
    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (gender != user.gender) return false;
        if (userDataId != user.userDataId) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (phoneNum != null ? !phoneNum.equals(user.phoneNum) : user.phoneNum != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (passportSeria != null ? !passportSeria.equals(user.passportSeria) : user.passportSeria != null)
            return false;
        if (passportNum != null ? !passportNum.equals(user.passportNum) : user.passportNum != null) return false;
        if (identicationNum != null ? !identicationNum.equals(user.identicationNum) : user.identicationNum != null)
            return false;
        if (passportWhoGive != null ? !passportWhoGive.equals(user.passportWhoGive) : user.passportWhoGive != null)
            return false;
        if (passportGiveDate != null ? !passportGiveDate.equals(user.passportGiveDate) : user.passportGiveDate != null)
            return false;
        if (livingCity != user.livingCity) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (homePhone != null ? !homePhone.equals(user.homePhone) : user.homePhone != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return citizenship == user.citizenship;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (passportSeria != null ? passportSeria.hashCode() : 0);
        result = 31 * result + (passportNum != null ? passportNum.hashCode() : 0);
        result = 31 * result + (identicationNum != null ? identicationNum.hashCode() : 0);
        result = 31 * result + (passportWhoGive != null ? passportWhoGive.hashCode() : 0);
        result = 31 * result + (passportGiveDate != null ? passportGiveDate.hashCode() : 0);
        result = 31 * result + (livingCity != null ? livingCity.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (citizenship != null ? citizenship.hashCode() : 0);
        result = 31 * result + userDataId;
        return result;
    }

    @Override
    public String toString() {
        return "UserdataEntity{" +
                "userDataId=" + userDataId +
                ", userName='" + userName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", passportSeria='" + passportSeria + '\'' +
                ", passportNum='" + passportNum + '\'' +
                ", identicationNum='" + identicationNum + '\'' +
                ", passportWhoGive='" + passportWhoGive + '\'' +
                ", passportGiveDate=" + passportGiveDate +
                ", livingCity=" + livingCity +
                ", address='" + address + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", email='" + email + '\'' +
                ", citizenship=" + citizenship +
                '}';
    }
}
