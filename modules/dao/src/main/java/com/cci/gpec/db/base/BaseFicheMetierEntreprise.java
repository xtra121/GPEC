package com.cci.gpec.db.base;

import java.io.Serializable;

/**
 * This class has been automatically generated by Hibernate Synchronizer. For
 * more information or documentation, visit The Hibernate Synchronizer page at
 * http://www.binamics.com/hibernatesync or contact Joe Hudson at
 * joe@binamics.com.
 * 
 * This is an object that contains data related to the FICHEMETIERENTREPRISE
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="FICHEMETIERENTREPRISE"
 */
public abstract class BaseFicheMetierEntreprise implements Serializable {

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.cci.gpec.db.FicheMetier ficheMetier;
	private com.cci.gpec.db.Entreprise entreprise;

	// constructors
	public BaseFicheMetierEntreprise() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFicheMetierEntreprise(
			com.cci.gpec.db.FicheMetier _idFicheMetier,
			com.cci.gpec.db.Entreprise _idEntreprise) {

		this.setFicheMetier(_idFicheMetier);
		this.setEntreprise(_idEntreprise);
		initialize();
	}

	protected void initialize() {
	}

	/**
	 * @hibernate.property column=ID_FICHE_METIER not-null=true
	 */
	public com.cci.gpec.db.FicheMetier getFicheMetier() {
		return this.ficheMetier;
	}

	/**
	 * Set the value related to the column: ID_FICHE_METIER
	 * 
	 * @param _idFicheMetier
	 *            the ID_FICHE_METIER value
	 */
	public void setFicheMetier(com.cci.gpec.db.FicheMetier ficheMetier) {
		this.ficheMetier = ficheMetier;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * @hibernate.property column=ID_ENTREPRISE not-null=true
	 */
	public com.cci.gpec.db.Entreprise getEntreprise() {
		return this.entreprise;
	}

	/**
	 * Set the value related to the column: ID_ENTREPRISE
	 * 
	 * @param _idEntreprise
	 *            the ID_ENTREPRISE value
	 */
	public void setEntreprise(com.cci.gpec.db.Entreprise entreprise) {
		this.entreprise = entreprise;
		this.hashCode = Integer.MIN_VALUE;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.cci.gpec.db.FicheMetierEntreprise))
			return false;
		else {
			com.cci.gpec.db.FicheMetierEntreprise mObj = (com.cci.gpec.db.FicheMetierEntreprise) obj;
			if (null != this.getFicheMetier() && null != mObj.getFicheMetier()) {
				if (!this.getFicheMetier().equals(mObj.getFicheMetier())) {
					return false;
				}
			} else {
				return false;
			}
			if (null != this.getEntreprise() && null != mObj.getEntreprise()) {
				if (!this.getEntreprise().equals(mObj.getEntreprise())) {
					return false;
				}
			} else {
				return false;
			}
			return true;
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getFicheMetier()) {
				sb.append(this.getFicheMetier().hashCode());
				sb.append(":");
			} else {
				return super.hashCode();
			}
			if (null != this.getEntreprise()) {
				sb.append(this.getEntreprise().hashCode());
				sb.append(":");
			} else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}