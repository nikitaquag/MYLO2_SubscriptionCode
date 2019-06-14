package com.mindyourlovedone.healthcare.pdfCreation;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.mindyourlovedone.healthcare.DashBoard.DateClass;
import com.mindyourlovedone.healthcare.database.DateQuery;
import com.mindyourlovedone.healthcare.model.Appoint;
import com.mindyourlovedone.healthcare.model.ContactData;
import com.mindyourlovedone.healthcare.model.Living;
import com.mindyourlovedone.healthcare.model.Note;
import com.mindyourlovedone.healthcare.model.Pet;
import com.mindyourlovedone.healthcare.model.VitalSigns;
import com.mindyourlovedone.healthcare.pdfdesign.Header;
import com.mindyourlovedone.healthcare.pdfdesign.HeaderNew;
import com.mindyourlovedone.healthcare.pdfdesign.RoundedBorder;

import java.util.ArrayList;

/**
 * Created by welcome on 11/7/2017.
 */

public class EventPdfNew {

    public static ArrayList<String> messageEvent = new ArrayList<String>();
    public static ArrayList<String> messageAppoint = new ArrayList<String>();
    public static ArrayList<String> messageLiving = new ArrayList<String>();

    Font BlackFont;

    private void EventNewFont() {
        try {
            BaseFont base = BaseFont.createFont("assets/Lato-Regular.ttf", "UTF-8",BaseFont.EMBEDDED);
            BlackFont = new Font(base, 19, Font.NORMAL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public EventPdfNew(ArrayList<Appoint> appointList, Image pp) {
        EventNewFont();
        try {
            HeaderNew.addNewChank("Appointment Checklist", pp);
            messageAppoint.add("Appointment Checklist");
            HeaderNew.addEmptyLine(1);


            for (int i = 0; i < appointList.size(); i++) {
                PdfPTable table1;
                table1 = new PdfPTable(1);
                table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                table1.setTableEvent(new RoundedBorder());
                table1.getDefaultCell().setPaddingBottom(15);
                table1.setKeepTogether(false);
                table1.setSplitLate(false);
                table1.setWidthPercentage(100);
                PdfPCell cell1 = new PdfPCell();
                cell1.setPaddingTop(10);
                cell1.setPaddingBottom(10);
                cell1.setBorder(Rectangle.NO_BORDER);
                cell1.setBackgroundColor(WebColors.getRGBColor("#Ffffff"));
                table1.setKeepTogether(false);
                table1.setSplitLate(false);

                PdfPTable table;
                table = new PdfPTable(2);
                table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                table.setKeepTogether(false);
                table.setSplitLate(false);
                table.setWidthPercentage(100);


                PdfPCell cell;
                Paragraph k1;

                Appoint s = appointList.get(i);

                String speciality = "";
                if (s.getType() != null) {
                    speciality = s.getType();
                    if (s.getType().equals("Other")) {
                        speciality = s.getOtherDoctor();
                    } else {
                        speciality = s.getType();
                    }
                }
                // cell = new PdfPCell(new Phrase("Type of Test or Specialist : " + speciality));
                cell = new PdfPCell();
                HeaderNew.cellDesign(cell, table1, "Type of Test or Specialist:", speciality);
                table.addCell(cell);

                messageAppoint.add("Type of Test or Specialist :");
                messageAppoint.add(speciality);

                String name = "";
                if (s.getDoctor() != null) {
                    name = s.getDoctor();
                }
                //  cell = new PdfPCell(new Phrase("Name of Doctor(if aplicable) : " + name));
                cell = new PdfPCell();
                HeaderNew.cellDesign(cell, table1, "Name of Doctor(if aplicable):", name);
                table.addCell(cell);

                messageAppoint.add("Name of Doctor(if aplicable) :");
                messageAppoint.add(name);

                String frequency = "";
                if (s.getFrequency() != null) {
                    frequency = s.getFrequency();
                    if (s.getFrequency().equals("Other")) {
                        frequency = s.getOtherFrequency();
                    } else {
                        frequency = s.getFrequency();
                    }
                }

                // cell = new PdfPCell(new Phrase("Frequency : " + frequency));
                cell = new PdfPCell();
                HeaderNew.cellDesign(cell, table1, "Frequency:", frequency);
                table.addCell(cell);

                messageAppoint.add("Frequency :");
                messageAppoint.add(frequency);

                String note = "";
                if (s.getNote() != null) {
                    note = s.getNote();
                }

                // cell = new PdfPCell(new Phrase("Note : " + note));
                cell = new PdfPCell();
                HeaderNew.cellDesign(cell, table1, "Note:", note);
                table.addCell(cell);
                messageAppoint.add("Note :");
                messageAppoint.add(note);

                ArrayList<DateClass> datelist = DateQuery.fetchAllDosageRecord(appointList.get(i).getUserid(), appointList.get(i).getUnique());

                BlackFont.setColor(WebColors.getRGBColor("#24AAE0"));//255, 99, 26);
                BlackFont.setSize(11.5f);
                BlackFont.setStyle(Font.BOLD);
                Paragraph pf = new Paragraph();
                Phrase pps = new Phrase();
                Chunk underlined = new Chunk("  ", BlackFont);
                pps.add(underlined);
                pf.add(pps);

                pps = new Phrase();
                Chunk underline = new Chunk("Date Completed", BlackFont);
                pps.add(underline);

                pf.add(pps);
                pf.setAlignment(Element.ALIGN_LEFT);

                cell = new PdfPCell();
                if (datelist.size() != 0) {
                    cell.addElement(pf);


                cell.setPaddingTop(5);
                cell.setBackgroundColor(WebColors.getRGBColor("#ffffff"));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(2);
               cell.setPaddingLeft(10);
                cell.setPaddingRight(10);
                cell.addElement(new Paragraph(" "));


                PdfPTable tableIN;
                    tableIN = new PdfPTable(2);
                    PdfPCell cellIN;
                    tableIN.setWidthPercentage(95);
                    tableIN.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                    tableIN.setTableEvent(new RoundedBorder());
                    tableIN.getDefaultCell().setPadding(2);
                    tableIN.setKeepTogether(false);
                    tableIN.setSplitLate(false);

                for (int j = 0; j < datelist.size(); j++) {
                    DateClass d = datelist.get(j);

                    String date = "";
                    if (d.getDate() != null) {
                        date = d.getDate();
                    }
                    int k = j + 1;
                    //cellIN = new PdfPCell(new Phrase("Name:" + name));
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "Date " + k + ":", date);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    if (j<2) {
                        cellIN.setPaddingTop(14);
                    }
                    tableIN.addCell(cellIN);

                    messageAppoint.add("Name :");
                    messageAppoint.add(name);


                   /* cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "", "Empty");
                    tableIN.addCell(cellIN);*/

                    messageAppoint.add("");
                    messageAppoint.add("");

                }
                if (datelist.size()%2!=0)
                {
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "", "Empty");
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));

                    tableIN.addCell(cellIN);

                }
                cell.addElement(tableIN);
                cell.addElement(new Paragraph(" "));
                }
                table.addCell(cell);
                cell1.addElement(table);
                table1.addCell(cell1);
                HeaderNew.document.add(table1);
                HeaderNew.addEmptyLine(1);

            }

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        }



    public EventPdfNew(ArrayList<Note> noteList, int j, Image pp) {
        EventNewFont();
        try {
            HeaderNew.addNewChank("Event Note", pp);
            messageEvent.add("Event Note");
            HeaderNew.addEmptyLine(1);


            for (int i = 0; i < noteList.size(); i++) {
                PdfPTable table1;
                table1 = new PdfPTable(1);
                table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                table1.setTableEvent(new RoundedBorder());
                table1.getDefaultCell().setPaddingBottom(15);
                table1.setKeepTogether(false);
                table1.setSplitLate(false);
                table1.setWidthPercentage(100);
                PdfPCell cell1 = new PdfPCell();
                cell1.setPaddingTop(10);
                cell1.setPaddingBottom(10);
                cell1.setBorder(Rectangle.NO_BORDER);
                cell1.setBackgroundColor(WebColors.getRGBColor("#Ffffff"));
                table1.setKeepTogether(false);
                table1.setSplitLate(false);

                PdfPTable table;
                table = new PdfPTable(2);
                table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                table.setKeepTogether(false);
                table.setSplitLate(false);
                table.setWidthPercentage(100);


                PdfPCell cell;
                Paragraph k1;

                Note s = noteList.get(i);

                String name = "";
                if (s.getTxtNote() != null) {
                    name = s.getTxtNote();
                }
              //  cell = new PdfPCell(new Phrase("Event Note : " + name));
                cell = new PdfPCell();
                HeaderNew.cellDesign(cell, table, "Event Note:", name);
                table.addCell(cell);

                messageEvent.add("Event Note :");
                messageEvent.add(name);


                String noteDate = "";
                if (s.getTxtDate() != null) {
                    noteDate = s.getTxtDate();
                }
               // cell = new PdfPCell(new Phrase("Event Date : " + noteDate));
                cell = new PdfPCell();
                HeaderNew.cellDesign(cell, table, "Event Date:", noteDate);
                table.addCell(cell);

                messageEvent.add("Event Date :");
                messageEvent.add(noteDate);

                cell = new PdfPCell();
                HeaderNew.cellDesign(cell, table, "", "Empty");
                table.addCell(cell);

                messageEvent.add("");
                messageEvent.add("");


                cell1.addElement(table);
                table1.addCell(cell1);
                HeaderNew.document.add(table1);
                HeaderNew.addEmptyLine(1);
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    public EventPdfNew(int k, Living s, int j, Image pp) {
       EventNewFont();
            try {
                HeaderNew.addNewChank("Activities of Daily Living", pp);
                messageLiving.add("Activities of Daily Living");
                HeaderNew.addEmptyLine(1);


                    PdfPTable table1;
                    table1 = new PdfPTable(1);
                    table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                    table1.setTableEvent(new RoundedBorder());
                    table1.getDefaultCell().setPaddingBottom(15);
                    table1.setKeepTogether(false);
                    table1.setSplitLate(false);
                    table1.setWidthPercentage(100);
                    PdfPCell cell1 = new PdfPCell();
                    cell1.setPaddingTop(10);
                    cell1.setPaddingBottom(10);
                    cell1.setBorder(Rectangle.NO_BORDER);
                    cell1.setBackgroundColor(WebColors.getRGBColor("#Ffffff"));
                    table1.setKeepTogether(false);
                    table1.setSplitLate(false);


                    PdfPTable table;
                    table = new PdfPTable(2);
                    table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                    table.setKeepTogether(false);
                    table.setSplitLate(false);
                    table.setWidthPercentage(100);

                    PdfPCell cell;
                    Paragraph k1;

                    // cell1 = new PdfPCell(new Phrase("Activities of Daily Living(ADL) " + ""));
                    BlackFont.setColor(WebColors.getRGBColor("#24AAE0"));//255, 99, 26);
                    BlackFont.setSize(11.5f);
                    BlackFont.setStyle(Font.BOLD);
                    Paragraph pf = new Paragraph();
                    Phrase pps = new Phrase();
                    Chunk underlined = new Chunk("  ", BlackFont);
                    pps.add(underlined);
                    pf.add(pps);

                    pps = new Phrase();
                    Chunk underline = new Chunk("Activities of Daily Living(ADL)", BlackFont);
                    pps.add(underline);

                    pf.add(pps);
                    pf.setAlignment(Element.ALIGN_LEFT);

                    cell = new PdfPCell();
                    cell.addElement(pf);
                    cell.setPaddingTop(5);
                    cell.setBackgroundColor(WebColors.getRGBColor("#ffffff"));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setColspan(2);
                    cell.setPaddingLeft(10);
                    cell.setPaddingRight(10);
                    cell.addElement(new Paragraph(" "));
                    table.addCell(cell);

                    messageLiving.add("Activities of Daily Living(ADL)" + "");
                    messageLiving.add("");

                  cell = new PdfPCell();
                  cell.setColspan(2);
                  cell.setBorder(Rectangle.NO_BORDER);

                    PdfPTable tableIN;
                    tableIN = new PdfPTable(2);
                    PdfPCell cellIN;
                    tableIN.setWidthPercentage(95);
                    tableIN.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                    tableIN.setTableEvent(new RoundedBorder());
                    tableIN.getDefaultCell().setPadding(2);
                    tableIN.setKeepTogether(false);
                    tableIN.setSplitLate(false);




                    String bathing = "";
                    if (s.getBath() != null) {
                        bathing = s.getBath();
                    }

                    //cell1 = new PdfPCell(new Phrase("Bathing : " + bathing));
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "Bathing:", bathing);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    cellIN.setPaddingTop(14);
                    tableIN.addCell(cellIN);
                    messageLiving.add("Bathing :");
                    messageLiving.add(bathing);

                    String continence = "";
                    if (s.getContinence() != null) {
                        continence = s.getContinence();
                    }
                    // cell1 = new PdfPCell(new Phrase("Continence : " + continence));
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "Continence:", continence);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    cellIN.setPaddingTop(14);
                    tableIN.addCell(cellIN);
                    messageLiving.add("Continence :");
                    messageLiving.add(continence);

                    String dressing = "";
                    if (s.getDress() != null) {
                        dressing = s.getDress();
                    }
                    //cell1 = new PdfPCell(new Phrase("Dressing : " + dressing));
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "Dressing:", dressing);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    tableIN.addCell(cellIN);
                    messageLiving.add("Dressing :");
                    messageLiving.add(dressing);

                    String eating = "";
                    if (s.getFeed() != null) {
                        eating = s.getFeed();
                    }
                    // cell1 = new PdfPCell(new Phrase("Eating : " + eating));
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "Eating:", eating);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    tableIN.addCell(cellIN);

                    messageLiving.add("Eating :");
                    messageLiving.add(eating);

                    String toileting = "";
                    if (s.getToileting() != null) {
                        toileting = s.getToileting();
                    }

                    //  cell1 = new PdfPCell(new Phrase("Toileting : " + toileting));
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "Toileting:", toileting);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    tableIN.addCell(cellIN);
                    messageLiving.add("Toileting :");
                    messageLiving.add(toileting);

                    String transfering = "";
                    if (s.getTransfer() != null) {
                        transfering = s.getTransfer();
                    }

                    // cell1 = new PdfPCell(new Phrase("Transfering : " + transfering));
                    cellIN = new PdfPCell();
                    HeaderNew.cellDesign(cellIN, tableIN, "Transfering:", transfering);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    tableIN.addCell(cellIN);

                    messageLiving.add("Transfering :");
                    messageLiving.add(transfering);

                    String functionOther = "";
                    if (s.getFunctionOther() != null) {
                        functionOther = s.getFunctionOther();
                    }
                    // cell1 = new PdfPCell(new Phrase("Other : " + functionOther));
                    cellIN = new PdfPCell();
                    cellIN.setColspan(2);
                    HeaderNew.cellDesign(cellIN, tableIN, "Other:", functionOther);
                    cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                    tableIN.addCell(cellIN);
                    messageLiving.add("Other-specify :");
                    messageLiving.add(functionOther);

                    cell.addElement(tableIN);
                    cell.addElement(new Paragraph(" "));
                    table.addCell(cell);

                    String functionNote = "";
                    if (s.getFunctionNote() != null) {
                        functionNote = s.getFunctionNote();
                    }
                    // cell1 = new PdfPCell(new Phrase("Note : " + functionNote));
                    cell = new PdfPCell();
                    cell.setColspan(2);
                    HeaderNew.cellDesign(cell, table, "Note:", functionNote);
                    table.addCell(cell);

                    messageLiving.add("Note :");
                    messageLiving.add(functionNote);


                    cell1.addElement(table);
                    table1.addCell(cell1);


                BlackFont.setColor(WebColors.getRGBColor("#24AAE0"));//255, 99, 26);
                BlackFont.setSize(11.5f);
                BlackFont.setStyle(Font.BOLD);
                 pf = new Paragraph();
                 pps = new Phrase();
                 underlined = new Chunk("  ", BlackFont);
                pps.add(underlined);
                pf.add(pps);

                pps = new Phrase();
                 underline = new Chunk("Instrumental Activities of Daily Living(IADL)", BlackFont);
                pps.add(underline);

                pf.add(pps);
                pf.setAlignment(Element.ALIGN_LEFT);

                cell = new PdfPCell();
                cell.addElement(pf);
                cell.setPaddingTop(5);
                cell.setBackgroundColor(WebColors.getRGBColor("#ffffff"));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(2);
                cell.setPaddingLeft(10);
                cell.setPaddingRight(10);
                cell.addElement(new Paragraph(" "));
                table.addCell(cell);

                messageLiving.add("Instrumental Activities of Daily Living(IADL)" + "");
                messageLiving.add("");

                cell = new PdfPCell();
                cell.setColspan(2);
                cell.setBorder(Rectangle.NO_BORDER);
               // PdfPTable tableIN;
                tableIN = new PdfPTable(2);
               // PdfPCell cellIN;
                tableIN.setWidthPercentage(95);
                tableIN.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                tableIN.setTableEvent(new RoundedBorder());
                tableIN.getDefaultCell().setPadding(2);
                tableIN.setKeepTogether(false);
                tableIN.setSplitLate(false);


                String access = "";
                if (s.getTransport() != null) {
                    access = s.getTransport();
                }
               // cell2 = new PdfPCell(new Phrase("Accessing Transportation : " + access));
                //cell1 = new PdfPCell(new Phrase("Bathing : " + bathing));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Accessing Transportation:", access);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                cellIN.setPaddingTop(14);
                tableIN.addCell(cellIN);
                messageLiving.add("Bathing :");
                messageLiving.add(bathing);

                String carePet = "";
                if (s.getPets() != null) {
                    carePet = s.getPets();
                }
               // cell2 = new PdfPCell(new Phrase("Caring for Pets : " + carePet));
                // cell1 = new PdfPCell(new Phrase("Continence : " + continence));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Caring for Pets:", carePet);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                cellIN.setPaddingTop(14);
                tableIN.addCell(cellIN);
                messageLiving.add("Continence :");
                messageLiving.add(continence);


                String driving = "";
                if (s.getDrive() != null) {
                    driving = s.getDrive();
                }
                //cell2 = new PdfPCell(new Phrase("Driving : " + driving));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Driving:", driving);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);
                messageLiving.add("Dressing :");
                messageLiving.add(dressing);

                String housekeeping = "";
                if (s.getKeep() != null) {
                    housekeeping = s.getKeep();
                }
                //cell2 = new PdfPCell(new Phrase("Housekeeping : " + housekeeping));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Housekeeping:", housekeeping);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Eating :");
                messageLiving.add(eating);

                String manage = "";
                if (s.getMedication() != null) {
                    manage = s.getMedication();
                }
                //cell2 = new PdfPCell(new Phrase("Managing Medications : " + manage));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Managing Medications:", manage);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);
                messageLiving.add("Toileting :");
                messageLiving.add(toileting);

                String finance = "";
                if (s.getFinance() != null) {
                    finance = s.getFinance();
                }
                //cell2 = new PdfPCell(new Phrase("Managing Personal Finances : " + finance));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Managing Personal Finances:", finance);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);

                String meal = "";
                if (s.getPrepare() != null) {
                    meal = s.getPrepare();
                }
               // cell2 = new PdfPCell(new Phrase("Preparing Meals : " + meal));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Preparing Meals:", meal);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);
                String shopping = "";
                if (s.getShop() != null) {
                    shopping = s.getShop();
                }
                //cell2 = new PdfPCell(new Phrase("Shopping for Groceries or Clothes : " + shopping));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Shopping for Groceries or Clothes:", shopping);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);

                String telephone = "";
                if (s.getUse() != null) {
                    telephone = s.getUse();
                }
               // cell2 = new PdfPCell(new Phrase("Using Telephone : " + telephone));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Using Telephone:", telephone);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);

                String computer = "";
                if (s.getComputer() != null) {
                    computer = s.getComputer();
                }
               // cell2 = new PdfPCell(new Phrase("Using a Computer or Tablet : " + computer));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Using a Computer or Tablet:", computer);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);

                String remote = "";
                if (s.getRemote() != null) {
                    remote = s.getRemote();
                }
                //cell2 = new PdfPCell(new Phrase("Using a Remote Control for the TV : " + remote));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Using a Remote Control for the TV:", remote);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);

                String alert = "";
                if (s.getAlert() != null) {
                    alert = s.getAlert();
                }
               // cell2 = new PdfPCell(new Phrase("Using a Medical Alert : " + alert));
                cellIN = new PdfPCell();
                HeaderNew.cellDesign(cellIN, tableIN, "Using a Medical Alert:", alert);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);

                String instOther = "";
                if (s.getInstOther() != null) {
                    instOther = s.getInstOther();
                }
               // cell2 = new PdfPCell(new Phrase("Other : " + instOther));
                cellIN = new PdfPCell();
                cellIN.setColspan(2);
                HeaderNew.cellDesign(cellIN, tableIN, "Other:", instOther);
                cellIN.setBackgroundColor(WebColors.getRGBColor("#FBFBFB"));
                tableIN.addCell(cellIN);
                messageLiving.add("Other-specify :");
                messageLiving.add(functionOther);

                cell.addElement(tableIN);
                cell.addElement(new Paragraph(" "));
                table.addCell(cell);

                String functionalNote = "";
                if (s.getInstNote() != null) {
                    functionalNote = s.getInstNote();
                }
                // cell1 = new PdfPCell(new Phrase("Note : " + functionNote));
                cell = new PdfPCell();
                cell.setColspan(2);
                HeaderNew.cellDesign(cell, table, "Note:", functionalNote);
                table.addCell(cell);

                messageLiving.add("Note :");
                messageLiving.add(functionNote);


                cell1.addElement(table);
                table1.addCell(cell1);
                    HeaderNew.document.add(table1);
                    HeaderNew.addEmptyLine(1);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public EventPdfNew(String vital, ArrayList<VitalSigns> vitalList) {
        try {
            //Header.addEmptyLine(1);
            Header.addChank("Vital Signs");
            messageLiving.add("Vital Signs");
            Header.addEmptyLine(1);

            PdfPTable table;
            table = new PdfPTable(2);
            PdfPCell cell;
            table.setWidthPercentage(100);

            for (int i = 0; i < vitalList.size(); i++) {

                PdfPTable table1;
                table1 = new PdfPTable(2);
                PdfPCell cell1;
                table1.setWidthPercentage(100);

                /*cell1 = new PdfPCell(new Phrase("Activities of Daily Living(ADL) " + ""));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Activities of Daily Living(ADL)" + "");
                messageLiving.add("");

                cell1 = new PdfPCell(new Phrase(""));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);
                messageLiving.add("");
                messageLiving.add("");

                cell1 = new PdfPCell(new Phrase("Needs Help With" + " :"));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Needs Help With" + " :");
                messageLiving.add("");

                cell1 = new PdfPCell(new Phrase(""));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);
                messageLiving.add("");
                messageLiving.add("");
*/
                VitalSigns s = vitalList.get(i);



                String continence = "";
                if (s.getDate() != null) {
                    continence = s.getDate();
                }
                cell1 = new PdfPCell(new Phrase("Date : " + continence));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Date :");
                messageLiving.add(continence);

                String dressing = "";
                if (s.getTime() != null) {
                    dressing = s.getTime();
                }
                cell1 = new PdfPCell(new Phrase("Time : " + dressing));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);
                messageLiving.add("Dressing :");
                messageLiving.add(dressing);

                String bathing = "";
                if (s.getLocation() != null) {
                    bathing = s.getLocation();
                }

                cell1 = new PdfPCell(new Phrase("Location : " + bathing));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Bathing :");
                messageLiving.add(bathing);

                String eating = "";
                if (s.getBp() != null) {
                    eating = s.getBp();
                }
                cell1 = new PdfPCell(new Phrase("Blood Pressure : " + eating));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Blood Pressure :");
                messageLiving.add(eating);

                String toileting = "";
                if (s.getHeartRate() != null) {
                    toileting = s.getHeartRate();
                }

                cell1 = new PdfPCell(new Phrase("Heart Rate : " + toileting));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Heart Rate :");
                messageLiving.add(toileting);

                String transfering = "";
                if (s.getTemperature() != null) {
                    transfering = s.getTemperature();
                }

                cell1 = new PdfPCell(new Phrase("Temperature : " + transfering));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Temperature :");
                messageLiving.add(transfering);

                Header.document.add(table1);
                Paragraph p2 = new Paragraph(" ");
                DottedLineSeparator line2 = new DottedLineSeparator();
                line2.setOffset(-4);
                line2.setLineColor(BaseColor.BLACK);
                p2.add(line2);
                Header.document.add(p2);
                Header.addEmptyLine(1);

//------------
                PdfPTable tablep;
                tablep = new PdfPTable(2);
                PdfPCell cellp;
                tablep.setWidthPercentage(100);

                String functionOther = "";
                if (s.getPulseRate() != null) {
                    functionOther = s.getPulseRate();
                }
                cell1 = new PdfPCell(new Phrase("Pulse Rate : " + functionOther));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                tablep.addCell(cell1);
                messageLiving.add("Pulse Rate :");
                messageLiving.add(functionOther);

                String functionNote = "";
                if (s.getRespRate() != null) {
                    functionNote = s.getRespRate();
                }
                cell1 = new PdfPCell(new Phrase("Respiratory Rate : " + functionNote));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                tablep.addCell(cell1);

                messageLiving.add("Respiratory Rate :");
                messageLiving.add(functionNote);

                String Col = "";
                if (s.getCol() != null) {
                    Col = s.getCol();
                }
                cell1 = new PdfPCell(new Phrase("Cholesterol : " + Col));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                tablep.addCell(cell1);

                messageLiving.add("Cholesterol :");
                messageLiving.add(Col);

                String oter = "";
                if (s.getOther() != null) {
                    oter = s.getOther();
                }
                cell1 = new PdfPCell(new Phrase("Other : " + oter));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                tablep.addCell(cell1);

                messageLiving.add("Other :");
                messageLiving.add(oter);

                String Note = "";
                if (s.getNote() != null) {
                    Note = s.getNote();
                }
                cell1 = new PdfPCell(new Phrase("Note : " + Note));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                tablep.addCell(cell1);

                messageLiving.add("Note :");
                messageLiving.add(Note);

                cell1 = new PdfPCell(new Phrase(""));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                tablep.addCell(cell1);

                messageLiving.add("");
                messageLiving.add("");

                Header.document.add(tablep);
                Paragraph p = new Paragraph(" ");
                DottedLineSeparator line = new DottedLineSeparator();
                line.setOffset(-4);
                line.setLineColor(BaseColor.BLACK);
                p.add(line);
                Header.document.add(p);
                Header.addEmptyLine(1);

            }
           /* Paragraph p = new Paragraph(" ");
            DottedLineSeparator line = new DottedLineSeparator();
            line.setOffset(-4);
            line.setLineColor(BaseColor.LIGHT_GRAY);
            p.add(line);
            Header.document.add(p);*/
            // Header.addEmptyLine(1);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
