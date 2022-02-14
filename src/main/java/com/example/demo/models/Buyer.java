package com.example.demo.models;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "buyer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name")
  @NotBlank(message = "Это обязательное поле.")
  @Size(min = 2, max = 32, message = "Поле должно содержать от 2 до 32 символов.")
  private String name;

  @Column(name = "surname")
  @Size(min = 2, max = 32, message = "Поле должно содержать от 2 до 32 символов.")
  @NotBlank(message = "Это обязательное поле.")
  private String surname;

  @Column(name = "patronymic")
  @NotBlank(message = "Это обязательное поле.")
  @Size(min = 2, max = 32, message = "Поле должно содержать от 2 до 32 символов.")
  private String patronymic;

  @Column(name = "passport_number")
  @Pattern(regexp = "[0-9]{10}", message = "Поле должно содержать 10 символов.")
  @NotBlank(message = "Это обязательное поле.")
  private String passportNumber;

  @Column(name = "day_of_birth")
  @Past(message = "Поле может содержать только прошедшую дату.")
  @DateTimeFormat(iso = ISO.DATE)
  @NotNull(message = "Это обязательное поле.")
  private Date dayOfBirth;

  @Column(name = "phone_number")
  @Pattern(regexp = "[+]*[0-9]{5,11}", message = "Поле должно содержать от 5 до 12 символов.")
  @NotBlank(message = "Это обязательное поле.")
  private String phoneNumber;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer", cascade = CascadeType.DETACH)
  private Set<Bid> bids;
}