package com.cci.gpec.db.base;

import java.io.Serializable;

/**
 * This class has been automatically generated by Hibernate Synchronizer. For
 * more information or documentation, visit The Hibernate Synchronizer page at
 * http://www.binamics.com/hibernatesync or contact Joe Hudson at
 * joe@binamics.com.
 * 
 * This is an object that contains data related to the ACCIDENT table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="ACCIDENT"
 */
public abstract class BaseAccident implements Serializable {

	public static String PROP_NOMBRE_JOUR_ARRET = "NombreJourArret";
	public static String PROP_ID_SALARIE = "IdSalarie";
	public static String PROP_AGGRAVATION = "Aggravation";
	public static String PROP_COMMENTAIRE = "Commentaire";
	public static String PROP_DATE_ACCIDENT = "DateAccident";
	public static String PROP_ID_ABSENCE = "IdAbsence";
	public static String PROP_NOMBRE_JOUR_ARRET_RECHUTE = "NombreJourArretRechute";
	public static String PROP_DATE_RECHUTE = "DateRechute";
	public static String PROP_ID_TYPE_LESION_RECHUTE = "IdTypeLesionRechute";
	public static String PROP_ID_TYPE_ACCIDENT = "IdTypeAccident";
	public static String PROP_ID = "Id";
	public static String PROP_ID_TYPE_LESION = "IdTypeLesion";
	public static String PROP_INITIAL = "Initial";
	public static String PROP_JUSTIFICATIF = "Justificatif";
	public static String PROP_ID_TYPE_CAUSE_ACCIDENT = "IdTypeCauseAccident";

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private Boolean _initial;
	private Boolean _aggravation;
	private java.util.Date _dateAccident;
	private java.util.Date _dateRechute;
	private java.lang.Integer _nombreJourArret;
	private java.lang.Integer _nombreJourArretRechute;
	private java.lang.String _justificatif;
	private java.lang.String _commentaire;

	// many to one
	private com.cci.gpec.db.Typelesion typeLesion;
	private com.cci.gpec.db.Typelesion typeLesionRechute;
	private com.cci.gpec.db.Typecauseaccident typeCauseAccident;
	private com.cci.gpec.db.Typeaccident typeAccident;
	private com.cci.gpec.db.Salarie salarie;
	private com.cci.gpec.db.Absence absence;

	// constructors
	public BaseAccident() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccident(java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	protected void initialize() {
	}

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="identity" column="ID_ACCIDENT"
	 */
	public java.lang.Integer getId() {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param _id
	 *            the new ID
	 */
	public void setId(java.lang.Integer _id) {
		this._id = _id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: INITIAL
	 */
	public Boolean isInitial() {
		return _initial;
	}

	/**
	 * Set the value related to the column: INITIAL
	 * 
	 * @param _initial
	 *            the INITIAL value
	 */
	public void setInitial(Boolean _initial) {
		this._initial = _initial;
	}

	/**
	 * Return the value associated with the column: AGGRAVATION
	 */
	public Boolean isAggravation() {
		return _aggravation;
	}

	/**
	 * Set the value related to the column: AGGRAVATION
	 * 
	 * @param _aggravation
	 *            the AGGRAVATION value
	 */
	public void setAggravation(Boolean _aggravation) {
		this._aggravation = _aggravation;
	}

	/**
	 * Return the value associated with the column: DATE_ACCIDENT
	 */
	public java.util.Date getDateAccident() {
		return _dateAccident;
	}

	/**
	 * Set the value related to the column: DATE_ACCIDENT
	 * 
	 * @param _dateAccident
	 *            the DATE_ACCIDENT value
	 */
	public void setDateAccident(java.util.Date _dateAccident) {
		this._dateAccident = _dateAccident;
	}

	/**
	 * Return the value associated with the column: DATE_RECHUTE
	 */
	public java.util.Date getDateRechute() {
		return _dateRechute;
	}

	/**
	 * Set the value related to the column: DATE_RECHUTE
	 * 
	 * @param _dateRechute
	 *            the DATE_RECHUTE value
	 */
	public void setDateRechute(java.util.Date _dateRechute) {
		this._dateRechute = _dateRechute;
	}

	/**
	 * Return the value associated with the column: NOMBRE_JOUR_ARRET
	 */
	public java.lang.Integer getNombreJourArret() {
		return _nombreJourArret;
	}

	/**
	 * Set the value related to the column: NOMBRE_JOUR_ARRET
	 * 
	 * @param _nombreJourArret
	 *            the NOMBRE_JOUR_ARRET value
	 */
	public void setNombreJourArret(java.lang.Integer _nombreJourArret) {
		this._nombreJourArret = _nombreJourArret;
	}

	/**
	 * Return the value associated with the column: NOMBRE_JOUR_ARRET_RECHUTE
	 */
	public java.lang.Integer getNombreJourArretRechute() {
		return _nombreJourArretRechute;
	}

	/**
	 * Set the value related to the column: NOMBRE_JOUR_ARRET_RECHUTE
	 * 
	 * @param _nombreJourArretRechute
	 *            the NOMBRE_JOUR_ARRET_RECHUTE value
	 */
	public void setNombreJourArretRechute(
			java.lang.Integer _nombreJourArretRechute) {
		this._nombreJourArretRechute = _nombreJourArretRechute;
	}

	/**
	 * Return the value associated with the column: JUSTIFICATIF
	 */
	public java.lang.String getJustificatif() {
		return _justificatif;
	}

	/**
	 * Set the value related to the column: JUSTIFICATIF
	 * 
	 * @param _justificatif
	 *            the JUSTIFICATIF value
	 */
	public void setJustificatif(java.lang.String _justificatif) {
		this._justificatif = _justificatif;
	}

	/**
	 * Return the value associated with the column: COMMENTAIRE
	 */
	public java.lang.String getCommentaire() {
		return _commentaire;
	}

	/**
	 * Set the value related to the column: COMMENTAIRE
	 * 
	 * @param _commentaire
	 *            the COMMENTAIRE value
	 */
	public void setCommentaire(java.lang.String _commentaire) {
		this._commentaire = _commentaire;
	}

	/**
	 * @hibernate.property column=ID_TYPE_LESION
	 */
	public com.cci.gpec.db.Typelesion getTypeLesion() {
		return this.typeLesion;
	}

	/**
	 * Set the value related to the column: ID_TYPE_LESION
	 * 
	 * @param _idTypeLesion
	 *            the ID_TYPE_LESION value
	 */
	public void setTypeLesion(com.cci.gpec.db.Typelesion typeLesion) {
		this.typeLesion = typeLesion;
	}

	/**
	 * @hibernate.property column=ID_TYPE_LESION_RECHUTE
	 */
	public com.cci.gpec.db.Typelesion getTypeLesionRechute() {
		return this.typeLesionRechute;
	}

	/**
	 * Set the value related to the column: ID_TYPE_LESION_RECHUTE
	 * 
	 * @param _idTypeLesionRechute
	 *            the ID_TYPE_LESION_RECHUTE value
	 */
	public void setTypeLesionRechute(
			com.cci.gpec.db.Typelesion typeLesionRechute) {
		this.typeLesionRechute = typeLesionRechute;
	}

	/**
	 * @hibernate.property column=ID_TYPE_CAUSE_ACCIDENT
	 */
	public com.cci.gpec.db.Typecauseaccident getTypeCauseAccident() {
		return this.typeCauseAccident;
	}

	/**
	 * Set the value related to the column: ID_TYPE_CAUSE_ACCIDENT
	 * 
	 * @param _idTypeCauseAccident
	 *            the ID_TYPE_CAUSE_ACCIDENT value
	 */
	public void setTypeCauseAccident(
			com.cci.gpec.db.Typecauseaccident typeCauseAccident) {
		this.typeCauseAccident = typeCauseAccident;
	}

	/**
	 * @hibernate.property column=ID_TYPE_ACCIDENT
	 */
	public com.cci.gpec.db.Typeaccident getTypeAccident() {
		return this.typeAccident;
	}

	/**
	 * Set the value related to the column: ID_TYPE_ACCIDENT
	 * 
	 * @param _idTypeAccident
	 *            the ID_TYPE_ACCIDENT value
	 */
	public void setTypeAccident(com.cci.gpec.db.Typeaccident typeAccident) {
		this.typeAccident = typeAccident;
	}

	/**
	 * @hibernate.property column=ID_SALARIE
	 */
	public com.cci.gpec.db.Salarie getSalarie() {
		return this.salarie;
	}

	/**
	 * Set the value related to the column: ID_SALARIE
	 * 
	 * @param _idSalarie
	 *            the ID_SALARIE value
	 */
	public void setSalarie(com.cci.gpec.db.Salarie salarie) {
		this.salarie = salarie;
	}

	/**
	 * @hibernate.property column=ID_ABSENCE
	 */
	public com.cci.gpec.db.Absence getAbsence() {
		return this.absence;
	}

	/**
	 * Set the value related to the column: ID_ABSENCE
	 * 
	 * @param _idAbsence
	 *            the ID_ABSENCE value
	 */
	public void setAbsence(com.cci.gpec.db.Absence absence) {
		this.absence = absence;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.cci.gpec.db.base.BaseAccident))
			return false;
		else {
			com.cci.gpec.db.base.BaseAccident mObj = (com.cci.gpec.db.base.BaseAccident) obj;
			if (null == this.getId() || null == mObj.getId())
				return false;
			else
				return (this.getId().equals(mObj.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}