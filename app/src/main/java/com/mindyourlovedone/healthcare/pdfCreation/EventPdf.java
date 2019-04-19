package com.mindyourlovedone.healthcare.pdfCreation;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.mindyourlovedone.healthcare.DashBoard.DateClass;
import com.mindyourlovedone.healthcare.database.DateQuery;
import com.mindyourlovedone.healthcare.model.Appoint;
import com.mindyourlovedone.healthcare.model.Living;
import com.mindyourlovedone.healthcare.model.Note;
import com.mindyourlovedone.healthcare.model.VitalSigns;
import com.mindyourlovedone.healthcare.pdfdesign.Header;

import java.util.ArrayList;

/**
 * Created by welcome on 11/7/2017.
 */

public class EventPdf {

    public static ArrayList<String> messageEvent = new ArrayList<String>();
    public static ArrayList<String> messageAppoint = new ArrayList<String>();
    public static ArrayList<String> messageLiving = new ArrayList<String>();


    public EventPdf(ArrayList<Appoint> appointList) {
        try {
           // Header.addEmptyLine(1);
            Header.addChank("Appointment Checklist");
            messageAppoint.add("Appointment Checklist");
            Header.addEmptyLine(1);

            PdfPTable table1;
            table1 = new PdfPTable(2);
            PdfPCell cell1;
            table1.setWidthPercentage(100);


            for (int i = 0; i < appointList.size(); i++) {

                PdfPTable table;
                table = new PdfPTable(2);
                PdfPCell cell;
                table.setWidthPercentage(100);

               /* int k = i + 1;
                cell = new PdfPCell(new Phrase("Appointment Checklist " + k + " :"));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);
                messageAppoint.add("Appointment Checklist " + k + " :");
                messageAppoint.add("");*/

                Appoint s = appointList.get(i);

                String speciality = "";
                if (s.getType() != null) {
                    speciality = s.getType();
                }
                cell = new PdfPCell(new Phrase("Type of Test or Specialist : " + speciality));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageAppoint.add("Type of Test or Specialist :");
                messageAppoint.add(speciality);

                String name = "";
                if (s.getDoctor() != null) {
                    name = s.getDoctor();
                }
                cell = new PdfPCell(new Phrase("Name of Doctor(if aplicable) : " + name));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageAppoint.add("Name of Doctor(if aplicable) :");
                messageAppoint.add(name);

                String frequency = "";
                if (s.getFrequency() != null) {
                    frequency = s.getFrequency();
                }

                cell = new PdfPCell(new Phrase("Frequency : " + frequency));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageAppoint.add("Frequency :");
                messageAppoint.add(frequency);

                String note = "";
                if (s.getNote() != null) {
                    note = s.getNote();
                }

                cell = new PdfPCell(new Phrase("Note : " + note));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageAppoint.add("Note :");
                messageAppoint.add(note);

                cell = new PdfPCell(new Phrase("Date Completed" + " :"));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);
                messageAppoint.add("Date Completed" + " :");
                messageAppoint.add("");

                cell = new PdfPCell(new Phrase(""));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);
                messageAppoint.add("");
                messageAppoint.add("");

                ArrayList<DateClass> datelist = DateQuery.fetchAllDosageRecord(appointList.get(i).getUserid(), appointList.get(i).getUnique());
                for (int j = 0; j < datelist.size(); j++) {
                  /*  k = j + 1;
                    cell = new PdfPCell(new Phrase("Date Completed " + k + " :"));
                    cell.setBorder(Rectangle.BOTTOM);
                    cell.setUseBorderPadding(true);
                    cell.setBorderWidthBottom(5);
                    cell.setBorderColorBottom(BaseColor.WHITE);
                    table.addCell(cell);
                    messageAppoint.add("Date Completed " + k + " :");
                    messageAppoint.add("");*/

                    DateClass d = datelist.get(j);

                    String date = "";
                    if (d.getDate() != null) {
                        date = d.getDate();
                    }
                    cell = new PdfPCell(new Phrase(date));
                    cell.setBorder(Rectangle.BOTTOM);
                    cell.setUseBorderPadding(true);
                    cell.setBorderWidthBottom(5);
                    cell.setBorderColorBottom(BaseColor.WHITE);
                    table.addCell(cell);
                    messageAppoint.add("");
                    messageAppoint.add(date);

                    cell = new PdfPCell(new Phrase(""));
                    cell.setBorder(Rectangle.BOTTOM);
                    cell.setUseBorderPadding(true);
                    cell.setBorderWidthBottom(5);
                    cell.setBorderColorBottom(BaseColor.WHITE);
                    table.addCell(cell);
                    messageAppoint.add("");
                    messageAppoint.add("");
                }
              /*  if (!(datelist.size() % 2 == 0)) {
                    cell = new PdfPCell(new Phrase(""));
                    cell.setBorder(Rectangle.BOTTOM);
                    cell.setUseBorderPadding(true);
                    cell.setBorderWidthBottom(5);
                    cell.setBorderColorBottom(BaseColor.WHITE);
                    table.addCell(cell);
                    messageAppoint.add("");
                    messageAppoint.add("");
                }*/


                Header.document.add(table);

                Paragraph p = new Paragraph(" ");
                DottedLineSeparator line = new DottedLineSeparator();
                line.setOffset(-4);
                line.setLineColor(BaseColor.BLACK);
                p.add(line);
                Header.document.add(p);
                Header.addEmptyLine(1);
            }
            Header.document.add(table1);
           // Header.addEmptyLine(1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public EventPdf(ArrayList<Note> noteList, int i) {
        try {
           // Header.addEmptyLine(1);
            Header.addChank("Event Notes");
            messageEvent.add("Event Notes");
            Header.addEmptyLine(1);

            PdfPTable table1;
            table1 = new PdfPTable(2);
            PdfPCell cell1;
            table1.setWidthPercentage(100);


            for (i = 0; i < noteList.size(); i++) {
                PdfPTable table;
                table = new PdfPTable(2);
                PdfPCell cell;
                table.setWidthPercentage(100);
/*
                int k = i + 1;
                cell = new PdfPCell(new Phrase("Event Notes " + k + " :"));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageEvent.add("Event Notes " + k + " :");
                messageEvent.add("");*/

                Note s = noteList.get(i);

                String name = "";
                if (s.getTxtNote() != null) {
                    name = s.getTxtNote();
                }
                cell = new PdfPCell(new Phrase("Event Note : " + name));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageEvent.add("Event Note :");
                messageEvent.add(name);


                String noteDate = "";
                if (s.getTxtDate() != null) {
                    noteDate = s.getTxtDate();
                }
                cell = new PdfPCell(new Phrase("Event Date : " + noteDate));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageEvent.add("Event Date :");
                messageEvent.add(noteDate);

                cell = new PdfPCell(new Phrase(""));
                cell.setBorder(Rectangle.BOTTOM);
                cell.setUseBorderPadding(true);
                cell.setBorderWidthBottom(5);
                cell.setBorderColorBottom(BaseColor.WHITE);
                table.addCell(cell);

                messageEvent.add("");
                messageEvent.add("");

                Header.document.add(table);

                Paragraph p = new Paragraph(" ");
                DottedLineSeparator line = new DottedLineSeparator();
                line.setOffset(-4);
                line.setLineColor(BaseColor.BLACK);
//                line.setLineColor(BaseColor.LIGHT_GRAY);
                p.add(line);
                Header.document.add(p);
                Header.addEmptyLine(1);
            }
            Header.document.add(table1);
          //  Header.addEmptyLine(1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public EventPdf(int k, ArrayList<Living> livingList, int i) {
        try {
            //Header.addEmptyLine(1);
            Header.addChank("Activities of Daily Living");
            messageLiving.add("Activities of Daily Living");
            Header.addEmptyLine(1);

            PdfPTable table;
            table = new PdfPTable(2);
            PdfPCell cell;
            table.setWidthPercentage(100);

            for (i = 0; i < livingList.size(); i++) {

                PdfPTable table1;
                table1 = new PdfPTable(2);
                PdfPCell cell1;
                table1.setWidthPercentage(100);

                cell1 = new PdfPCell(new Phrase("Activities of Daily Living(ADL) " + ""));
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

                Living s = livingList.get(i);

                String bathing = "";
                if (s.getBath() != null) {
                    bathing = s.getBath();
                }

                cell1 = new PdfPCell(new Phrase("Bathing : " + bathing));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Bathing :");
                messageLiving.add(bathing);

                String continence = "";
                if (s.getContinence() != null) {
                    continence = s.getContinence();
                }
                cell1 = new PdfPCell(new Phrase("Continence : " + continence));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Continence :");
                messageLiving.add(continence);

                String dressing = "";
                if (s.getDress() != null) {
                    dressing = s.getDress();
                }
                cell1 = new PdfPCell(new Phrase("Dressing : " + dressing));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);
                messageLiving.add("Dressing :");
                messageLiving.add(dressing);

                String eating = "";
                if (s.getFeed() != null) {
                    eating = s.getFeed();
                }
                cell1 = new PdfPCell(new Phrase("Eating : " + eating));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Eating :");
                messageLiving.add(eating);

                String toileting = "";
                if (s.getToileting() != null) {
                    toileting = s.getToileting();
                }

                cell1 = new PdfPCell(new Phrase("Toileting : " + toileting));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Toileting :");
                messageLiving.add(toileting);

                String transfering = "";
                if (s.getTransfer() != null) {
                    transfering = s.getTransfer();
                }

                cell1 = new PdfPCell(new Phrase("Transfering : " + transfering));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Transfering :");
                messageLiving.add(transfering);

                String functionOther = "";
                if (s.getFunctionOther() != null) {
                    functionOther = s.getFunctionOther();
                }
                cell1 = new PdfPCell(new Phrase("Other : " + functionOther));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);
                messageLiving.add("Other-specify :");
                messageLiving.add(functionOther);

                String functionNote = "";
                if (s.getFunctionNote() != null) {
                    functionNote = s.getFunctionNote();
                }
                cell1 = new PdfPCell(new Phrase("Note : " + functionNote));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("Note :");
                messageLiving.add(functionNote);

                Header.document.add(table1);
                Paragraph p = new Paragraph(" ");
                DottedLineSeparator line = new DottedLineSeparator();
                line.setOffset(-4);
                line.setLineColor(BaseColor.BLACK);
                p.add(line);
                Header.document.add(p);
                Header.addEmptyLine(1);

                PdfPTable table2;
                table2 = new PdfPTable(2);
                PdfPCell cell2;
                table2.setWidthPercentage(100);

                cell2 = new PdfPCell(new Phrase("Instrumental Activities of Daily Living(IADL) " + ""));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Instrumental Activities of Daily Living(IADL)" + "");
                messageLiving.add("");

                cell2 = new PdfPCell(new Phrase(""));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);
                messageLiving.add("");
                messageLiving.add("");

                cell2 = new PdfPCell(new Phrase("Needs Help With" + " :"));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Needs Help With" + " :");
                messageLiving.add("");

                cell2 = new PdfPCell(new Phrase(""));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);
                messageLiving.add("");
                messageLiving.add("");

                String access = "";
                if (s.getTransport() != null) {
                    access = s.getTransport();
                }
                cell2 = new PdfPCell(new Phrase("Accessing Transportation : " + access));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Accessing Transportation :");
                messageLiving.add(access);

                String carePet = "";
                if (s.getPets() != null) {
                    carePet = s.getPets();
                }
                cell2 = new PdfPCell(new Phrase("Caring for Pets : " + carePet));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Caring for pets :");
                messageLiving.add(carePet);

                String driving = "";
                if (s.getDrive() != null) {
                    driving = s.getDrive();
                }
                cell2 = new PdfPCell(new Phrase("Driving : " + driving));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Driving :");
                messageLiving.add(driving);

                String housekeeping = "";
                if (s.getKeep() != null) {
                    housekeeping = s.getKeep();
                }
                cell2 = new PdfPCell(new Phrase("Housekeeping : " + housekeeping));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Housekeeping :");
                messageLiving.add(housekeeping);

                String manage = "";
                if (s.getMedication() != null) {
                    manage = s.getMedication();
                }
                cell2 = new PdfPCell(new Phrase("Managing Medications : " + manage));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Managing Medications :");
                messageLiving.add(manage);

                String finance = "";
                if (s.getFinance() != null) {
                    finance = s.getFinance();
                }
                cell2 = new PdfPCell(new Phrase("Managing Personal Finances : " + finance));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);
                messageLiving.add("Managing personal finances :");
                messageLiving.add(finance);

                String meal = "";
                if (s.getPrepare() != null) {
                    meal = s.getPrepare();
                }
                cell2 = new PdfPCell(new Phrase("Preparing Meals : " + meal));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Preparing meals :");
                messageLiving.add(meal);

                String shopping = "";
                if (s.getShop() != null) {
                    shopping = s.getShop();
                }
                cell2 = new PdfPCell(new Phrase("Shopping for Groceries or Clothes : " + shopping));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Shopping for groceries or clothes :");
                messageLiving.add(shopping);

                String telephone = "";
                if (s.getUse() != null) {
                    telephone = s.getUse();
                }
                cell2 = new PdfPCell(new Phrase("Using Telephone : " + telephone));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Using Telephone :");
                messageLiving.add(telephone);

                String computer = "";
                if (s.getComputer() != null) {
                    computer = s.getComputer();
                }
                cell2 = new PdfPCell(new Phrase("Using a Computer or Tablet : " + computer));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Using a Computer or Tablet :");
                messageLiving.add(computer);

                String remote = "";
                if (s.getRemote() != null) {
                    remote = s.getRemote();
                }
                cell2 = new PdfPCell(new Phrase("Using a Remote Control for the TV : " + remote));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Using a Remote Control for the TV :");
                messageLiving.add(remote);

                String alert = "";
                if (s.getAlert() != null) {
                    alert = s.getAlert();
                }
                cell2 = new PdfPCell(new Phrase("Using a Medical Alert : " + alert));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Using a Medical Alert :");
                messageLiving.add(alert);

                String instOther = "";
                if (s.getInstOther() != null) {
                    instOther = s.getInstOther();
                }
                cell2 = new PdfPCell(new Phrase("Other : " + instOther));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Other-specify :");
                messageLiving.add(instOther);

                String instNote = "";
                if (s.getInstNote() != null) {
                    instNote = s.getInstNote();
                }
                cell2 = new PdfPCell(new Phrase("Note : " + instNote));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);

                messageLiving.add("Note :");
                messageLiving.add(instNote);

                cell2 = new PdfPCell(new Phrase(""));
                cell2.setBorder(Rectangle.BOTTOM);
                cell2.setUseBorderPadding(true);
                cell2.setBorderWidthBottom(5);
                cell2.setBorderColorBottom(BaseColor.WHITE);
                table2.addCell(cell2);
                messageLiving.add("");
                messageLiving.add("");


                Header.document.add(table2);
                Paragraph p1 = new Paragraph(" ");
                DottedLineSeparator line1 = new DottedLineSeparator();
                line1.setOffset(-4);
                line1.setLineColor(BaseColor.BLACK);
                p1.add(line1);
                Header.document.add(p1);
                Header.addEmptyLine(1);

            }
            Header.document.add(table);
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

    public EventPdf(String vital, ArrayList<VitalSigns> vitalList) {
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

                String functionOther = "";
                if (s.getPulseRate() != null) {
                    functionOther = s.getPulseRate();
                }
                cell1 = new PdfPCell(new Phrase("Pulse Rate : " + functionOther));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);
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
                table1.addCell(cell1);

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
                table1.addCell(cell1);

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
                table1.addCell(cell1);

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
                table1.addCell(cell1);

                messageLiving.add("Note :");
                messageLiving.add(Note);

                cell1 = new PdfPCell(new Phrase(""));
                cell1.setBorder(Rectangle.BOTTOM);
                cell1.setUseBorderPadding(true);
                cell1.setBorderWidthBottom(5);
                cell1.setBorderColorBottom(BaseColor.WHITE);
                table1.addCell(cell1);

                messageLiving.add("");
                messageLiving.add("");
                Header.document.add(table1);
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
