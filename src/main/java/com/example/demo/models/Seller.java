package com.example.demo.models;


import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Data
@Table(name = "seller")
public class Seller {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name")
  @Size(min = 2, max = 32, message = "Поле должно содержать от 2 до 32 символов.")
  private String name;

  @Column(name = "surname")
  @Size(min = 2, max = 32, message = "Поле должно содержать от 2 до 32 символов.")
  private String surname;

  @Column(name = "patronymic")
  @Size(min = 2, max = 32, message = "Поле должно содержать от 2 до 32 символов.")
  private String patronymic;

  @Column(name = "passport_number")
  @Pattern(regexp = "[0-9]{10}", message = "Это поле должно содерать только цифры.")
  @Size(max = 10)
  private String passportNumber;

  @Column(name = "day_of_birth")
  @Past(message = "Поле может содержать только прошедшую дату.")
  @DateTimeFormat(iso = ISO.DATE)
  private Date dayOfBirth;

  @Column(name = "company_title")
  @Size(min = 2, max = 32, message = "Поле должно содержать от 2 до 32 символов.")
  private String companyTitle;

  @Column(name = "company_inn")
  @Pattern(regexp = "[0-9]{12}", message = "Поле должно содержать только цифры.")
  @Size(max = 12)
  private String innCompany;

  @Column(name = "phone_number")
  @Pattern(regexp = "[+]*[0-9]{5,11}", message = "Поле должно содержать от 5 до 12 символов.")
  @NotBlank(message = "Это обязательное поле.")
  private String phoneNumber;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller", cascade = CascadeType.DETACH)
  private Set<Bid> bids;
}