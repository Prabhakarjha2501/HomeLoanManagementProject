
package org.LifeEasyHomeLoan.main.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.LifeEasyHomeLoan.main.enums.CustomerLoanStatus;
import org.LifeEasyHomeLoan.main.exception.PdfNotGenerated;
import org.LifeEasyHomeLoan.main.model.Customer;
import org.LifeEasyHomeLoan.main.model.SanctionLetter;
import org.LifeEasyHomeLoan.main.repository.CustomerRepository;
import org.LifeEasyHomeLoan.main.servicei.SanctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class SanctionServiceImpl implements SanctionService{
	@Autowired
	CustomerRepository cr;
	private static final Logger LOGGER=LoggerFactory.getLogger(SanctionServiceImpl.class); 
	
	@Override
	public Iterable<Customer> getCustomerbyStatus(String customerLoanStatus) {
		Iterable<Customer> get = cr.findByCustomerLoanStatus(customerLoanStatus);
		return get;
	}
	@Override
	public ByteArrayInputStream generateSactionId(Integer customerId, SanctionLetter sanctionLetter)throws PdfNotGenerated 
	 {
		
		Optional<Customer> customerdetails = cr.findById(customerId);
		Customer customerdetails1 = customerdetails.get();
		
		if(customerdetails.isPresent()) {
			customerdetails1.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.SanctionLetterGenerated));
			customerdetails1.getSanctionLetter().setSanctionDate(sanctionLetter.getSanctionDate());
			customerdetails1.getSanctionLetter().setApplicantName(sanctionLetter.getApplicantName());
			customerdetails1.getSanctionLetter().setContactDetails(sanctionLetter.getContactDetails());
			customerdetails1.getSanctionLetter().setProductHomeEquity(sanctionLetter.getProductHomeEquity());
			customerdetails1.getSanctionLetter().setLoanAmtsanctioned(sanctionLetter.getLoanAmtsanctioned());
			customerdetails1.getSanctionLetter().setIntrestType(sanctionLetter.getIntrestType());
			customerdetails1.getSanctionLetter().setRateOfIntrest(sanctionLetter.getRateOfIntrest());
			customerdetails1.getSanctionLetter().setLoanTenure(sanctionLetter.getLoanTenure());
			customerdetails1.getSanctionLetter().setMonthlyEmiAmount(sanctionLetter.getMonthlyEmiAmount());
		
			LOGGER.info("Sanction Letter PDF Generation Started");
			String title = "LifeEasy HomeLoan Ltd.";
		
			Document document = new Document(PageSize.A4);
	
			String content1 = "\n\n Dear " + customerdetails1.getCustomerName()
			+ ","
			+ "\nLifeeasyHomeloan Ltd. is Happy to informed you that your loan application has been approved. ";

	String content2 = "\n\nWe hope that you find the terms and conditions of this loan satisfactory "
			+ "and that it will help you meet your financial needs.\n\nIf you have any questions or need any assistance regarding your loan, "
			+ "please do not hesitate to contact us.\n\nWe wish you all the best and thank you for choosing us."
			+ "\n\nSincerely,\n\n" + "Pravin Dongare (Credit Manager)";
							
	
	       ByteArrayOutputStream opt = new ByteArrayOutputStream();
	     
	       PdfWriter.getInstance(document, opt);
			document.open();
	       
			
			Image img = null;
			try {
				img = Image.getInstance("D:\\pravin img.jpg");
				img.scalePercent(50, 50);
				img.setAlignment(Element.ALIGN_RIGHT);
				document.add(img);

			} catch (BadElementException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
			Paragraph titlepara = new Paragraph(title, titlefont);
			titlepara.setAlignment(Element.ALIGN_CENTER);
			document.add(titlepara);
		
			Font titlefont2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent1 = new Paragraph(content1, titlefont2);
			document.add(paracontent1);
		
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 2, 2 });
			table.setSpacingBefore(10);

			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(CMYKColor.WHITE);
			cell.setPadding(5);

			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font.setColor(5, 5, 161);

			Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(5, 5, 161);

			cell.setPhrase(new Phrase("Loan amount Sanctioned", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf("₹ " + customerdetails1.getSanctionLetter().getLoanAmtsanctioned()),
					font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("loan tenure", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(customerdetails1.getSanctionLetter().getLoanTenure()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("interest rate", font));
			table.addCell(cell);

			cell.setPhrase(
					new Phrase(String.valueOf(customerdetails1.getSanctionLetter().getRateOfIntrest()) + " %", font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Sanction letter generated Date", font));
			table.addCell(cell);

			Date date = new Date();
			String curdate = date.toString();
			customerdetails1.getSanctionLetter().setSanctionDate(curdate);
			cell.setPhrase(
					new Phrase(String.valueOf(customerdetails1.getSanctionLetter().getSanctionDate()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Total loan Amount with Intrest", font));
			table.addCell(cell);

			document.add(table);

			Font titlefont3 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent2 = new Paragraph(content2, titlefont3);
			document.add(paracontent2);
			document.close();
			
			ByteArrayInputStream byt = new ByteArrayInputStream(opt.toByteArray());
			byte[] bytes = byt.readAllBytes();
			customerdetails1.getSanctionLetter().setSanctionLetter(bytes);
	    Customer ss=cr.save(customerdetails1);
			return byt;
		}
		else 
		{
			throw new PdfNotGenerated();
		}
	 
		}
		
	}

	
