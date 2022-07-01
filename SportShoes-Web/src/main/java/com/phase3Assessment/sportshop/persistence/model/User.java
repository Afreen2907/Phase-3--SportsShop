package com.phase3Assessment.sportshop.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="users")
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		@NotEmpty
		@Column(nullable=false)
		private String firstName;
		
		private String lastName;
		
		
		@Column(nullable=false,unique =true)
		@NotEmpty
		@Email(message="{errors.invalid_email}")
		private String email;
		
		
		private String password;
															// one user can have multiple roles,one role have multiple user
																//cascade:koi roll delete kiya to usse related sab user delete ho jaye   // agar user ko delete kiya to uske nam ke sare order delete
		@ManyToMany(cascade=CascadeType.MERGE, fetch =FetchType.EAGER)                                
		@JoinTable(
				name="user_role",
				joinColumns = {@JoinColumn(name="user_id",referencedColumnName="id") },
				inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
				)
			
		private List<Role> roles;
		




		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @return the roles
		 */
		public List<Role> getRoles() {
			return roles;
		}

		/**
		 * @param roles the roles to set
		 */
		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}

		public User(User user) {
			super();
			
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.email = user.getEmail();
			this.password = user.getPassword();
			this.roles = user.getRoles();
		}	
		
		public User() {}
		
		
		
		

	
			
}
