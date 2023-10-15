package com.moss.fuse.integrator.custom.model.base;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @Column(nullable = false, updatable = false)
   @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
   protected Long id;

}
