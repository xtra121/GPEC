package com.cci.gpec.web.jasperreport.print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.cci.gpec.commons.EntrepriseBean;
import com.cci.gpec.commons.FicheMetierBean;
import com.cci.gpec.commons.FicheMetierBeanExport;
import com.cci.gpec.commons.FicheMetierEntrepriseBean;
import com.cci.gpec.commons.StatutBean;
import com.cci.gpec.metier.implementation.EntrepriseServiceImpl;
import com.cci.gpec.metier.implementation.FicheMetierEntrepriseServiceImpl;
import com.cci.gpec.metier.implementation.FicheMetierServiceImpl;
import com.cci.gpec.metier.implementation.StatutServiceImpl;
import com.cci.gpec.web.Utils;

public class PrintFicheMetierEntreprise extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer idEntreprise = (Integer) request.getSession().getAttribute(
					"idEntreprise");
			printFicheMetier(request, response, idEntreprise);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 704992979558623612L;

	/*
	 */
	public String printFicheMetier(HttpServletRequest request,
			HttpServletResponse response, int idEntreprise) throws Exception {

		String nomGroupe = request.getSession().getAttribute("nomGroupe")
				.toString();

		try {
			List<FicheMetierBeanExport> ficheMetierBeanListE = new ArrayList<FicheMetierBeanExport>();

			FicheMetierEntrepriseServiceImpl ficheMetierEntreprise = new FicheMetierEntrepriseServiceImpl();
			List<FicheMetierEntrepriseBean> ficheMetierEntreprisesInventory = ficheMetierEntreprise
					.getFicheMetierEntrepriseBeanListByIdEntreprise(idEntreprise);
			List<FicheMetierBean> ficheMetierBeanList = new ArrayList<FicheMetierBean>();

			for (FicheMetierEntrepriseBean ficheMetierEntrepriseBean : ficheMetierEntreprisesInventory) {
				FicheMetierServiceImpl ficheMetierService = new FicheMetierServiceImpl();
				FicheMetierBean ficheMetierBean = ficheMetierService
						.getFicheMetierBeanById(ficheMetierEntrepriseBean
								.getIdFicheMetier());
				ficheMetierBeanList.add(ficheMetierBean);
			}

			int i = 0;
			for (FicheMetierBean ficheMetierBean : ficheMetierBeanList) {
				StatutServiceImpl statutService = new StatutServiceImpl();
				if (ficheMetierBean.getCspReference() != -1) {
					StatutBean statutBean = statutService
							.getStatutBeanById(ficheMetierBean
									.getCspReference());
					ficheMetierBean.setCsp(statutBean.getNom());
				} else {
					ficheMetierBean.setCsp("Non renseignée");
				}

				if (i == ficheMetierBeanList.size() - 1)
					ficheMetierBean.setCatalogue(false);
				else
					ficheMetierBean.setCatalogue(true);

				EntrepriseServiceImpl entrepriseService = new EntrepriseServiceImpl();
				EntrepriseBean entrepriseBean = entrepriseService
						.getEntrepriseBeanById(idEntreprise);
				ficheMetierBean.setLibelleEntreprise(entrepriseBean.getNom());
				if (entrepriseBean.getJustificatif() != null
						&& !entrepriseBean.getJustificatif().equals(""))
					ficheMetierBean.setUrl(Utils.getFileUrl(idEntreprise,
							"logo_entreprise", false, false, true, true,
							nomGroupe));
				ficheMetierBean.setJustificatif(entrepriseBean
						.getJustificatif());
				i++;
			}

			FicheMetierBeanExport fm = new FicheMetierBeanExport();
			fm.setFichesMetierList(ficheMetierBeanList);

			ficheMetierBeanListE.add(fm);

			JRDataSource jRDataSource = new JRBeanCollectionDataSource(
					ficheMetierBeanListE);

			String realPath = getServletConfig().getServletContext()
					.getRealPath("/reportTemplates/FichesMetier.jrxml");

			JasperDesign jasperDesign = JRXmlLoader.load(realPath);

			JasperDesign jasperDesignSub = JRXmlLoader.load(request
					.getSession().getServletContext().getRealPath("/")
					+ "reportTemplates/FichesMetier_subreport1.jrxml");

			HashMap<String, Object> jasperMap = new HashMap<String, Object>();

			// COMPILATION des template
			JasperReport jasperReport = JasperCompileManager
					.compileReport(jasperDesign);

			JasperCompileManager.compileReportToFile(jasperDesignSub, request
					.getSession().getServletContext().getRealPath("/")
					+ "reportTemplates/FichesMetier_subreport1.jasper");

			// création du virtualizer
			JRFileVirtualizer virtualizer = new JRFileVirtualizer(100);

			jasperMap.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);

			jasperMap.put("SUBREPORT_DIR", request.getSession()
					.getServletContext().getRealPath("/")
					+ "reportTemplates/");

			// Fill the report using an empty data source
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, jasperMap, jRDataSource);

			virtualizer.setReadOnly(true);

			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);

			/*******************************************************************
			 * Pour afficher une boîte de dialogue pour enregistrer le fichier
			 * sous le nom rapport.pdf
			 ******************************************************************/
			response.addHeader("Content-disposition",
					"attachment;filename=FichesMetier.pdf");
			response.setContentLength(bytes.length);
			response.getOutputStream().write(bytes);
			response.setContentType("application/pdf");

			// vidage du virtualizer
			virtualizer.cleanup();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
