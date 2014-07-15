/*
 * Neuroscience Gateway Proof of Concept/Research Portlet
 * This application was developed for research purposes at the Bioinformatics Laboratory of the AMC (The Netherlands)
 *
 * Copyright (C) 2013 Bioinformatics Laboratory, Academic Medical Center of the University of Amsterdam
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.amc.biolab.nsg.display.component;

import com.vaadin.Application;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import nl.amc.biolab.nsg.ProcessingStatus;
import nl.amc.biolab.nsg.display.VaadinTestApplication;
import nl.amc.biolab.nsg.display.data.DisplayProcessingStatus;
import nl.amc.biolab.nsg.display.service.ProcessingService;
import nl.amc.biolab.nsg.display.service.UserDataService;
import nl.amc.biolab.nsgdm.DataElement;
import nl.amc.biolab.nsgdm.Error;
import nl.amc.biolab.nsgdm.SubmissionIO;

import com.vaadin.terminal.StreamResource;
import com.vaadin.terminal.StreamResource.StreamSource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import nl.amc.biolab.nsgdm.Processing;
import nl.amc.biolab.nsgdm.Status;
import nl.amc.biolab.nsgdm.Submission;
import org.apache.log4j.Logger;

/**
 * @author initial architecture and implementation: m.almourabit@amc.uva.nl<br/>
 *
 */
class ProcessingStatusForm extends ViewerForm<DisplayProcessingStatus> {

    private static final long serialVersionUID = -3761299542545869266L;

    //text for testign html view
//    private static final String textInHtml = "<html> <head> <title>Neuroscience Gateway: Data History</title> <script type=\"application/javascript\"> <!-- 	document.write('Hello World!'); var ctx; var canvas; var w = 250; var h = 120; var cw = 500; var cx, cy; var idx = -1; var r = 50; var ch = 373; var ins = [3]; var links = [3]; var ys = [3]; var xs = [3]; var nlinks = 3; xs[0] = 33; ys[0] = 48; links[0] = \"http://mri-neutrino.amc.nl:8080/xnatZ0/data/archive/projects/test/subjects/012/experiments/xnatZ0_E00283/reconstructions/DTIPreprocessing_V1_0_NSG36/out/files/012.Recon.301.ZIP\"; txts[0] = \"output-DTIPreprocessing V1.0_NSG36\"; xs[1] = 33; ys[1] = 168; txts[1] = DTIPreprocessing_V1_0_NSG_351_2013-12-12-165017; xs[2] = 33; ys[2] = 288; links[2] = \"http://mri-neutrino.amc.nl:8080/xnatZ0/data/experiments/xnatZ0_E00283/scans/301/resources/DICOM/files?format=zip\"; txts[2] = \"012.DTI_64 b1000.301.DICOM\"; function draw() { canvas = document.getElementById(\"canvas\"); if (!canvas.getContext) { return; } ctx = canvas.getContext(\"2d\"); ctx.canvas.width = cw; ctx.canvas.height = ch; canvas.addEventListener(\"mousemove\", on_mousemove, false); canvas.addEventListener(\"click\", on_click, false); ctx.save(); for (var i=0;i<cw*ch/10000;++i) randomCircle(ctx,'#f7f3f7'); var start = 0; var end = 0; end = drawEllipse(ctx, 10, 10, w+6, h/2+6,'#ffffcc'); end = drawEllipse(ctx, 13, 13, w, h/2,'#ffffcc'); drawText(ctx, 33, 48,'#000000', 'output-DTIPreprocessing V1.0_NSG36'); drawText2(ctx, 13, 13,'#0099ff', 'Subject ID: 012'); drawText2(ctx, 13, 25,'#0099ff', 'Scan ID: 301'); drawText2(ctx, 13, 49,'#0099ff', 'Data Type: Recon DTIPreprocessing V1.0'); drawText2(ctx, 13, 61,'#0099ff', 'Data Format: ZIP'); drawText2(ctx, 13, 73,'#0099ff', 'Creation Date: 2013-12-12 20:00:21.0'); drawText3(ctx, 13, 13,'#0099ff', 'Data ID: 480'); start = rectangle(ctx, 13, 133, '#33ff00'); drawText(ctx, 33, 168,'#000000', 'DTIPreprocessing V1.0'); drawText3(ctx, -17, 133,'#0099ff', 'Version: null'); drawText2(ctx, 13, 133,'#0099ff', 'Submission Date: 2013-12-12 16:50:17.0'); drawText2(ctx, 13, 145,'#0099ff', 'Submitter: Ammar Benabdelkader'); drawText2(ctx, 13, 169,'#0099ff', 'Start Date: 2013-12-12 16:50:17.0'); drawText2(ctx, 13, 181,'#0099ff', 'End Date: 2013-12-12 20:00:21.0'); drawText2(ctx, 13, 193,'#0099ff', 'Description: DTI prep by ammar'); ctx.lineWidth = 1; ctx.fillStyle = ctx.strokeStyle = '#990000'; arrow(ctx,start,end,5); end = drawEllipse(ctx, 13, 253, w, h/2,'#ffffcc'); drawText(ctx, 33, 288,'#000000', '012.DTI_64 b1000.301.DICOM'); arrow2(ctx,end,5); drawText2(ctx, 13, 253,'#0099ff', 'Subject ID: 012'); drawText2(ctx, 13, 265,'#0099ff', 'Scan ID: 301'); drawText2(ctx, 13, 289,'#0099ff', 'Data Type: DTI_64 b1000'); drawText2(ctx, 13, 301,'#0099ff', 'Data Format: DICOM'); drawText2(ctx, 13, 313,'#0099ff', 'Creation Date: 2013-04-12 12:47:20.0'); drawText3(ctx, 13, 253,'#0099ff', 'Data ID: 413'); } function arrow(ctx,p1,p2,size){ ctx.beginPath(); ctx.fillStyle = '#990000' ctx.lineCap = 'round'; ctx.moveTo(p1.x+w/2, p1.y); ctx.lineTo(p1.x+w/2,p2.y+h/2);  ctx.stroke(); ctx.moveTo(p1.x+w/2,p2.y+h/2); ctx.lineTo(p1.x+w/2-size, p2.y+h/2+size*2.5); ctx.lineTo(p1.x+w/2+size, p2.y+h/2+size*2.5); ctx.closePath(); ctx.fill(); } function arrow2(ctx,p1,size){ ctx.beginPath(); ctx.fillStyle = '#990000' ctx.lineCap = 'round'; ctx.moveTo(p1.x+w/2, p1.y-h/2); ctx.lineTo(p1.x+w/2, p1.y); ctx.stroke(); ctx.moveTo(p1.x+w/2, p1.y-h/2); ctx.lineTo(p1.x+w/2-size, p1.y-h/2+size*2.5); ctx.lineTo(p1.x+w/2+size, p1.y-h/2+size*2.5); ctx.closePath(); ctx.fill(); } function rectangle(ctx,x, y, color){ ctx.fillStyle = color; ctx.fillRect(x,y,w,h/2); ctx.strokeRect(x,y,w,h/2); ctx.fillStyle = '#FFFFFF'; ctx.font = \"24px Arial\"; return {x:x,y:y}; } function drawText(ctx,x, y, color, txt){ ctx.fillStyle = color; ctx.font = \"bold 12px Verdana\";  ctx.fillText(txt,x,y); ctx.fillStyle = '#00000'; } function drawText2(ctx,x, y, color, txt){ ctx.fillStyle = color; ctx.font = \"13px Calibri\"; ctx.fillText('- ' + txt,x+w+5,y+10); } function drawText3(ctx,x, y, color, txt){ ctx.fillStyle = color; ctx.font = \"13px Calibri\"; ctx.fillText('- ' + txt,x+50,y+h/2-8); } function circle(ctx,x,y, color){ ctx.beginPath(); ctx.arc(x, y, 50, 0, 20, false); ctx.fillStyle = color; ctx.fill(); ctx.stroke(); return {x:x,y:y}; } function circle(ctx,x,y, color){ ctx.save(); ctx.beginPath(); ctx.arc(x+w/2, y, 50, 0, Math.PI * 2, false); ctx.fillStyle = color; ctx.fill(); ctx.stroke(); return {x:x,y:y}; } function randomCircle(ctx,color){ ctx.save(); ctx.beginPath(); ctx.arc( Math.round(Math.random()*(ctx.canvas.width - 100) + 50), Math.round(Math.random()*(ctx.canvas.height - 100) + 50), Math.random()*20 + 10, 0, Math.PI * 2, false ); ctx.fillStyle = color; ctx.fill(); ctx.restore(); } function drawEllipse(ctx, x, y, w, h, color) { var kappa = .5522848, ox = (w / 2) * kappa, oy = (h / 2) * kappa, xe = x + w, ye = y + h, xm = x + w / 2, ym = y + h / 2; ctx.beginPath(); ctx.moveTo(x, ym); ctx.bezierCurveTo(x, ym - oy, xm - ox, y, xm, y); ctx.bezierCurveTo(xm + ox, y, xe, ym - oy, xe, ym); ctx.bezierCurveTo(xe, ym + oy, xm + ox, ye, xm, ye); ctx.bezierCurveTo(xm - ox, ye, x, ym + oy, x, ym); ctx.fillStyle = color; ctx.fill(); ctx.closePath(); ctx.stroke(); return {x:x,y:y}; } function on_click(e) { if (idx>=0) { window.location = links[idx]; } } function on_mousemove (ev) { var x, y;  if (ev.layerX || ev.layerX == 0) { x = ev.layerX; y = ev.layerY; } else if (ev.offsetX || ev.offsetX == 0) {  x = ev.offsetX; y = ev.offsetY; }  ctx.font = \"12px sans-serif\"; ctx.fillStyle = \"rgba(0, 128, 0, 1.0)\"; var str = x.toString() + \",\" + y.toString(); ctx.clearRect (0, 0, 60, 15); ctx.fillText(str, 0, 10); for(i=0; i<nlinks; i++) { var tw = 200; var th = 10;  if ( (x>=(xs[i]) && x<=(xs[i]+tw)) && (y>=(ys[i]-th) && y<=(ys[i])) ) { if (!ins[i]) { document.body.style.cursor = \"pointer\";  ins[i] = true; idx = i; } } else { if (ins[i]) { ins[i] = false; document.body.style.cursor = \"\"; } } } } --> </script> </head><body onload=\"javascript:draw();\">hello<div id=\"wrap\">wrap</div><canvas id=\"canvas\" width=\"1\" height=\"1\">canvas</canvas>bye</body></html>";
//    private static final String textInHtml = "<html> <head> <TITLE>Neuroscience Gateway: Data History</title> <style type=\"text/css\"> body { background:#eee; margin:2em 4em; text-align:center; } canvas { background:#fff; border:1px solid #666 } </style> <script type=\"application/javascript\"> <!-- var ctx; var canvas; var w = 250; var h = 120; var cw = 500; var cx, cy; var idx = -1; var r = 50; var ch = 373; var ins = [3]; var links = [3]; var ys = [3]; var xs = [3]; var nlinks = 3; xs[0] = 33; ys[0] = 48; links[0] = \"http://mri-neutrino.amc.nl:8080/xnatZ0/data/archive/projects/test/subjects/012/experiments/xnatZ0_E00283/reconstructions/DTIPreprocessing_V1_0_NSG36/out/files/012.Recon.301.ZIP\"; txts[0] = \"output-DTIPreprocessing V1.0_NSG36\"; xs[1] = 33; ys[1] = 168; txts[1] = DTIPreprocessing_V1_0_NSG_351_2013-12-12-165017; xs[2] = 33; ys[2] = 288; links[2] = \"http://mri-neutrino.amc.nl:8080/xnatZ0/data/experiments/xnatZ0_E00283/scans/301/resources/DICOM/files?format=zip\"; txts[2] = \"012.DTI_64 b1000.301.DICOM\"; function draw() { canvas = document.getElementById(\"canvas\"); if (!canvas.getContext) { return; } ctx = canvas.getContext(\"2d\"); ctx.canvas.width = cw; ctx.canvas.height = ch; canvas.addEventListener(\"mousemove\", on_mousemove, false); canvas.addEventListener(\"click\", on_click, false); ctx.save(); for (var i=0;i<cw*ch/10000;++i) randomCircle(ctx,'#f7f3f7'); var start = 0; var end = 0; end = drawEllipse(ctx, 10, 10, w+6, h/2+6,'#ffffcc'); end = drawEllipse(ctx, 13, 13, w, h/2,'#ffffcc'); drawText(ctx, 33, 48,'#000000', 'output-DTIPreprocessing V1.0_NSG36'); drawText2(ctx, 13, 13,'#0099ff', 'Subject ID: 012'); drawText2(ctx, 13, 25,'#0099ff', 'Scan ID: 301'); drawText2(ctx, 13, 49,'#0099ff', 'Data Type: Recon DTIPreprocessing V1.0'); drawText2(ctx, 13, 61,'#0099ff', 'Data Format: ZIP'); drawText2(ctx, 13, 73,'#0099ff', 'Creation Date: 2013-12-12 20:00:21.0'); drawText3(ctx, 13, 13,'#0099ff', 'Data ID: 480'); start = rectangle(ctx, 13, 133, '#33ff00'); drawText(ctx, 33, 168,'#000000', 'DTIPreprocessing V1.0'); drawText3(ctx, -17, 133,'#0099ff', 'Version: null'); drawText2(ctx, 13, 133,'#0099ff', 'Submission Date: 2013-12-12 16:50:17.0'); drawText2(ctx, 13, 145,'#0099ff', 'Submitter: Ammar Benabdelkader'); drawText2(ctx, 13, 169,'#0099ff', 'Start Date: 2013-12-12 16:50:17.0'); drawText2(ctx, 13, 181,'#0099ff', 'End Date: 2013-12-12 20:00:21.0'); drawText2(ctx, 13, 193,'#0099ff', 'Description: DTI prep by ammar'); ctx.lineWidth = 1; ctx.fillStyle = ctx.strokeStyle = '#990000'; arrow(ctx,start,end,5); end = drawEllipse(ctx, 13, 253, w, h/2,'#ffffcc'); drawText(ctx, 33, 288,'#000000', '012.DTI_64 b1000.301.DICOM'); arrow2(ctx,end,5); drawText2(ctx, 13, 253,'#0099ff', 'Subject ID: 012'); drawText2(ctx, 13, 265,'#0099ff', 'Scan ID: 301'); drawText2(ctx, 13, 289,'#0099ff', 'Data Type: DTI_64 b1000'); drawText2(ctx, 13, 301,'#0099ff', 'Data Format: DICOM'); drawText2(ctx, 13, 313,'#0099ff', 'Creation Date: 2013-04-12 12:47:20.0'); drawText3(ctx, 13, 253,'#0099ff', 'Data ID: 413'); } function arrow(ctx,p1,p2,size){ ctx.beginPath(); ctx.fillStyle = '#990000' ctx.lineCap = 'round'; ctx.moveTo(p1.x+w/2, p1.y); ctx.lineTo(p1.x+w/2,p2.y+h/2); // 50 + 10 of the ellipse ctx.stroke(); ctx.moveTo(p1.x+w/2,p2.y+h/2); ctx.lineTo(p1.x+w/2-size, p2.y+h/2+size*2.5); ctx.lineTo(p1.x+w/2+size, p2.y+h/2+size*2.5); ctx.closePath(); ctx.fill(); } function arrow2(ctx,p1,size){ ctx.beginPath(); ctx.fillStyle = '#990000' ctx.lineCap = 'round'; ctx.moveTo(p1.x+w/2, p1.y-h/2); ctx.lineTo(p1.x+w/2, p1.y); ctx.stroke(); ctx.moveTo(p1.x+w/2, p1.y-h/2); ctx.lineTo(p1.x+w/2-size, p1.y-h/2+size*2.5); ctx.lineTo(p1.x+w/2+size, p1.y-h/2+size*2.5); ctx.closePath(); ctx.fill(); } function rectangle(ctx,x, y, color){ ctx.fillStyle = color; ctx.fillRect(x,y,w,h/2); ctx.strokeRect(x,y,w,h/2); ctx.fillStyle = '#FFFFFF'; ctx.font = \"24px Arial\"; return {x:x,y:y}; } function drawText(ctx,x, y, color, txt){ ctx.fillStyle = color; ctx.font = \"bold 12px Verdana\"; //ctx.strokeText(txt,x+20,y+5+h/4); ctx.fillText(txt,x,y); ctx.fillStyle = '#00000'; } function drawText2(ctx,x, y, color, txt){ ctx.fillStyle = color; ctx.font = \"13px Calibri\"; ctx.fillText('- ' + txt,x+w+5,y+10); } function drawText3(ctx,x, y, color, txt){ ctx.fillStyle = color; ctx.font = \"13px Calibri\"; ctx.fillText('- ' + txt,x+50,y+h/2-8); } function circle(ctx,x,y, color){ ctx.beginPath(); ctx.arc(x, y, 50, 0, 20, false); ctx.fillStyle = color; ctx.fill(); ctx.stroke(); return {x:x,y:y}; } function circle(ctx,x,y, color){ ctx.save(); //ctx.translate(canvas.width/2, ctx.height/2); //ctx.scale(2, 1); ctx.beginPath(); ctx.arc(x+w/2, y, 50, 0, Math.PI * 2, false); ctx.fillStyle = color; ctx.fill(); ctx.stroke(); return {x:x,y:y}; } function randomCircle(ctx,color){ ctx.save(); ctx.beginPath(); ctx.arc( Math.round(Math.random()*(ctx.canvas.width - 100) + 50), Math.round(Math.random()*(ctx.canvas.height - 100) + 50), Math.random()*20 + 10, 0, Math.PI * 2, false ); ctx.fillStyle = color; ctx.fill(); ctx.restore(); } function drawEllipse(ctx, x, y, w, h, color) { var kappa = .5522848, ox = (w / 2) * kappa, oy = (h / 2) * kappa, xe = x + w, ye = y + h, xm = x + w / 2, ym = y + h / 2; ctx.beginPath(); ctx.moveTo(x, ym); ctx.bezierCurveTo(x, ym - oy, xm - ox, y, xm, y); ctx.bezierCurveTo(xm + ox, y, xe, ym - oy, xe, ym); ctx.bezierCurveTo(xe, ym + oy, xm + ox, ye, xm, ye); ctx.bezierCurveTo(xm - ox, ye, x, ym + oy, x, ym); ctx.fillStyle = color; ctx.fill(); ctx.closePath(); ctx.stroke(); return {x:x,y:y}; } function on_click(e) { if (idx>=0) { window.location = links[idx]; } } function on_mousemove (ev) { var x, y; // Get the mouse position relative to the canvas element. if (ev.layerX || ev.layerX == 0) { // Firefox x = ev.layerX; y = ev.layerY; } else if (ev.offsetX || ev.offsetX == 0) { // Opera x = ev.offsetX; y = ev.offsetY; } //--------------------- // draw the coords: //--------------------- ctx.font = \"12px sans-serif\"; ctx.fillStyle = \"rgba(0, 128, 0, 1.0)\"; var str = x.toString() + \",\" + y.toString(); ctx.clearRect (0, 0, 60, 15); ctx.fillText(str, 0, 10); //------------------------------------ //</ncirclese point is in a circle: //------------------------------------ for(i=0; i<nlinks; i++) { var tw = 200; //ctx.measureText(linkText).width; var th = 10; //ctx.measureText(linkText).height; if ( (x>=(xs[i]) && x<=(xs[i]+tw)) && (y>=(ys[i]-th) && y<=(ys[i])) ) { if (!ins[i]) { document.body.style.cursor = \"pointer\"; //ctx.beginPath(); //ctx.strokeText(txts[i],xs[i],ys[i]); //ctx.stroke(); ins[i] = true; idx = i; } } else { if (ins[i]) { //ctx.beginPath(); //ctx.fillText(txts[i],xs[i],ys[i]); //ctx.stroke(); ins[i] = false; document.body.style.cursor = \"\"; } } } } --> </script> </head><body onload=\"javascript:draw();\"><div id=\"wrap\"></div><canvas id=\"canvas\" width=\"1\" height=\"1\"></canvas></body></html>";
//    private static final String textInHtml = "<html> <body> <h1> Data History </h1> </body></html>";
    
    public static final String REFRESH = "Refresh";
    public static final String RESUME_ALL = "Resume All";
    public static final String REPORT = "View report";
    public static final String DELETE_FILES = "Delete files from grid";
    public static final String CANCEL = "Cancel";
    public static final String RESTART = "Start again";

    private Logger logger = Logger.getLogger(ProcessingStatusForm.class);
    private UserDataService userDataService;

    private DisplayProcessingStatus processingStatus;

    private final ProcessingStatusForm processingStatusForm = this;

    private ListSelect inputData = new ListSelect();

    private Button refreshButton = new NativeButton();
    private NativeButton cancelButton; // = new NativeButton();  // cancel the whole processing
    private NativeButton deleteFilesButton; // = new NativeButton();  // cancel the whole processing
    private NativeButton reportButton; // = new NativeButton();  // cancel the whole processing
    private NativeButton restartButton; // = new NativeButton(); // restart the whole processing
    private NativeButton resumeAllButton; // = new NativeButton(); // restart the whole processing

    // Submission buttons
    private NativeButton markFailButton;
    private NativeButton resubmitButton;
    private NativeButton viewStatusButton;
    private NativeButton remarksButton;

    private ProcessingService processingService;

    Table submissionTable = new Table();

    private static Map<String, String> colorMap = new LinkedHashMap<String, String>() {
        {
            put(ProcessingStatus.On_Hold.toString(), "#AA0000");
            put(ProcessingStatus.In_Progress.toString(), "#0000AA");
            put(";", "#FF9900");
            put(ProcessingStatus.Done.toString(), "#00AA00");
        }
    };

    public ProcessingStatusForm() {
        super();
    }

    public ProcessingStatusForm(UserDataService userDataService, ProcessingService processingService) {
        super();
//        refreshButton.setVisible(true);
        this.userDataService = userDataService;
        this.processingService = processingService;
    }

    public void setProcessingStatus(DisplayProcessingStatus processingStatus) {
        this.processingStatus = processingStatus;
    }

    private void showHTML(final String htmlContent, final Application app) throws IllegalArgumentException, NullPointerException {
        app.getMainWindow().addWindow(new Window() {
            {
                center();
                setWidth("75%");
                setHeight("600px");
                StreamResource.StreamSource source = new StreamResource.StreamSource() {
                    public InputStream getStream() {
                        return new ByteArrayInputStream(htmlContent.getBytes());
                    }
                };
                StreamResource resource = new StreamResource(source, "TestReport.html", app);
                Embedded e = new Embedded();
                e.setMimeType("text/html");
                e.setType(Embedded.TYPE_BROWSER);
                e.setWidth("100%");
                e.setHeight("590px");
                e.setSource(resource);
                addComponent(e);
            }
        });
    }

    @Override
    public void attach() {
        super.attach();

        final VaadinTestApplication app = (VaadinTestApplication) getApplication();
        logger.info("Getting attached to. Displaying " + processingStatus);
        final Processing processing = processingStatus.getProcessing();
        if (processingStatus == null || processing == null) {
            return;
        }

//		restartButton.setVisible(false);
//		cancelButton.setVisible(false);

        setDataSource(processingStatus);
        setData(processingStatus);
        logger.info("Continuing being attached to. Displaying " + processingStatus.getStatus() + " for " + processing.getDescription() + " with status " + processing.getStatus());

        removeAllComponents();

        addLabelField("processing.description", "Description");
        addLabelField("processing.date", "Creation date");
        final String processingUpdateDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(processing.getLastUpdate()); // when the status is last updated

        //dataelements
        if (processingStatus.getSubmissionIOs().size() != 0) {
            Label space = new Label("<div>&nbsp;</div>", Label.CONTENT_XHTML);
            space.setWidth("100%");
            space.setHeight("10px");
            getLayout().addComponent(space);
            submissionTable = new Table();
            submissionTable.setWidth("100%");
            submissionTable.setHeight("300px");
//            submissionTable.setCaption("data");
            submissionTable.setSelectable(true);
            submissionTable.setMultiSelect(true);
            submissionTable.setImmediate(true);
            submissionTable.addContainerProperty("input", Label.class, null);
            submissionTable.addContainerProperty("output", Label.class, null);
            submissionTable.addContainerProperty("view history", VerticalLayout.class, null);
            submissionTable.addContainerProperty("status", VerticalLayout.class, null);
            submissionTable.setColumnExpandRatio("input", 30f);
            submissionTable.setColumnExpandRatio("output", 20f);
            submissionTable.setColumnExpandRatio("view history", 20f);
            submissionTable.setColumnExpandRatio("status", 30f);

            for (Map<List<SubmissionIO>, List<SubmissionIO>> map : processingStatus.getSubmissionIOs()) { // submissions
                for (List<SubmissionIO> submissionIOinputs : map.keySet()) { // for each submission, there is ONE map actually
                    if (submissionIOinputs.isEmpty()) {
                        logger.error("Skipping a submission with no inputs in processing: "+processingStatus.getProcessing().getDbId());
                        continue;
                    }
                    
                    //inputs
                    StringBuffer inputValue = new StringBuffer();
                    for (SubmissionIO submissionIOinput : submissionIOinputs) {
                        DataElement inputElement = submissionIOinput.getDataElement();
                        inputValue.append("<a href='" + userDataService.getDownloadURI(inputElement.getDbId()) + "' target='_blank'>" + inputElement.getName() + "</a><br />");
                    }
                    Label input = new Label(inputValue.toString(), Label.CONTENT_XHTML);
                    input.setWidth("-1px");

                    //outputs
                    StringBuffer downloadValue = new StringBuffer();
//                    StringBuffer viewValue = new StringBuffer();
                    VerticalLayout historyLayout = new VerticalLayout();
                    Label download = null;
                    historyLayout.setWidth("100%");
                    final List<SubmissionIO> outputs = map.get(submissionIOinputs);
                    if (outputs.isEmpty()) {
                        download = new Label("No output available", Label.CONTENT_XHTML);
                    } else {
                        for (SubmissionIO submissionIOoutput : outputs) {
                            final DataElement outputElement = submissionIOoutput.getDataElement();
                            downloadValue.append("<a href='").append(userDataService.getDownloadURI(outputElement.getDbId())).append("' target='_blank'>download output</a><br />");
//                            viewValue.append("<a href='").append(userDataService.getViewURI(outputElement.getDbId())).append("' target='_blank'>view output</a><br />");

                            NativeButton viewHistoryButton = new NativeButton("history");
                            viewHistoryButton.addListener(new Button.ClickListener() {
                                @Override
                                public void buttonClick(ClickEvent event) {
                                    final String htmlContent = userDataService.getDataHistory(outputElement.getDbId());
                                    showHTML(htmlContent, app);
                                }
                            });
                            historyLayout.addComponent(viewHistoryButton);
                        }
                        download = new Label(downloadValue.toString()/*+viewValue.toString()*/, Label.CONTENT_XHTML);
                        download.setWidth("-1px");
                    }
                    
                    // status
                    VerticalLayout statusLayout = makeSubmissionStatusLayout(submissionIOinputs, processing, app);

                    //add table item
                    submissionTable.addItem(new Object[]{input, download, historyLayout, statusLayout}, null);
                }
            }
            getLayout().addComponent(submissionTable);
        }

        //total status
        Label space = new Label("<div>&nbsp;</div>", Label.CONTENT_XHTML);
        space.setWidth("100%");
        space.setHeight("10px");
        getLayout().addComponent(space);

        LabelField f = new LabelField();
        LabelField lastUpdateDateFieled = new LabelField();
        lastUpdateDateFieled.setLabelValue("<span style='font-size: 12px'><b>Last updated on:</b>&nbsp;</span>", processingUpdateDate);
        f.setLabelValue("<span style='font-size: 12px'><b>Overall status:</b>&nbsp;</span>", getStatus(processingStatus.getStatus(), null, false));
        getLayout().addComponent(f);
        getLayout().addComponent(lastUpdateDateFieled);
    }

    private VerticalLayout makeSubmissionStatusLayout(List<SubmissionIO> submissionIOinputs, final Processing processing, final VaadinTestApplication app) {
        StringBuffer statusValue = new StringBuffer();
        VerticalLayout statusLayout = new VerticalLayout();   
        statusLayout.setWidth("100%");
        final Submission submission = submissionIOinputs.get(0).getSubmission();    // There is at least one input!
        //get status information
        String submissionStatus = submission.getStatus();
        logger.info("Status is " + submissionStatus);
        Date lastUpdateDate = processing.getDate();
        final Iterator<Status> iterator = submission.getStatuses().iterator();
        Status st = null;
        while (iterator.hasNext()) {
            st = iterator.next();
        }
        if (st != null) {
            lastUpdateDate = st.getTimestamp();
        }
        String submissionUpdateDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(lastUpdateDate); // when the status is last updated
        
        Error error = processingService.getSubmissionError(submissionIOinputs.get(0).getSubmission().getDbId());
        if (error != null) {
            logger.info("Error message is " + error.getMessage());
        }
        statusValue.append(getStatus(submissionStatus, error, app.isAdminURL() && userDataService.isNSGAdmin())).append("\n");
        logger.info(statusValue);
        createSubmissionButtons(app, submissionIOinputs.get(0), error);
        
        Label status = new Label(statusValue.toString(), Label.CONTENT_XHTML);
        status.setDescription("Last updated on " + submissionUpdateDate);
        status.setWidth("80%");
        
        
        if (app.isAdminURL() && userDataService.isNSGAdmin() && (ProcessingStatus.On_Hold.equalsString(submissionStatus) || ProcessingStatus.In_Progress.equalsString(submissionStatus))) {
            resubmitButton.setWidth("-1px");
            statusLayout.addComponent(status);
            HorizontalLayout hl = new HorizontalLayout();
            hl.addComponent(viewStatusButton);
            hl.addComponent(resubmitButton);
            hl.addComponent(markFailButton);
            statusLayout.addComponent(hl);
//					} else if(submissionStatus.equals(ProcessingStatus.STAT_INIT)) {
            // TODO: The processing manager does not work properly if it has not started yet.
//						layout.addComponent(status);
//						layout.addComponent(markFailButton);
        } else if (ProcessingStatus.Aborted.equalsString(submissionStatus)) {
            statusLayout.addComponent(status);
            statusLayout.addComponent(remarksButton);
        } else {
            statusLayout.addComponent(status);
        }
        return statusLayout;
    }

    private void createSubmissionButtons(final VaadinTestApplication app, final SubmissionIO submissionIO, final Error error) {
//		if(((VaadinTestApplication) getApplication()).isAdminURL() && userDataService.isNSGAdmin()) {
        final Link statusLink = new Link("download", new StreamResource(new StreamSource() {
            public InputStream getStream() {
                String status;
                if (error != null) {
                    status = error.getCode() + "\n" + error.getMessage() + "\n" + error.getDescription();
                } else {
                    status = "No message";
                }
                return new ByteArrayInputStream(status.getBytes());
            }
        }, "status", getApplication()), "", 400, 300, 2);

        viewStatusButton = new NativeButton("Details");
        viewStatusButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                app.getMainWindow().addWindow(new Window() {
                    {
                        center();
                        setWidth("700px");
                        setHeight("500px");
                        VerticalLayout vl = new VerticalLayout();
                        vl.addComponent(statusLink);
                        String status;
                        if (error != null) {
                            status = error.getCode() + "\n" + error.getMessage() + "\n" + error.getDescription();
                        } else {
                            status = "No message";
                        }
                        //status += "<img src=\"images/prov.png\"";
                        vl.addComponent(new Label(status, Label.CONTENT_PREFORMATTED));
                        addComponent(vl);
                    }
                });
            }
        });

        resubmitButton = new NativeButton("Resume");
        resubmitButton.setData(processingStatusForm);
        resubmitButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                long dbId = processingStatus.getProcessing().getDbId();
//                long userID = processingStatus.getProcessing().getUsers().iterator().next().getDbId();
                long liferayID = app.getLiferayId(processingStatus.getProcessing().getUsers().iterator().next().getLiferayID());
                processingService.resubmit(dbId, submissionIO.getSubmission().getDbId(), userDataService.getUserId(), liferayID);
                processingStatusForm.attach();
//                processingStatus = processingService.getProcessingStatus(userDataService.getProcessing(dbId), userID, liferayID, false); // TODO: why is it false here?!
//                refreshButton.setData(processingStatus);
//                processingStatusForm.fireValueChange(false);//fireEvent(new Event(refreshButton));                                        
            }
        });

        markFailButton = new NativeButton("Abort");
        markFailButton.setData(processingStatusForm);
        markFailButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                app.getMainWindow().addWindow(new Window() {
                    {
                        final Window window = this;
                        center();
                        setWidth("500px");
                        setHeight("300px");
                        VerticalLayout vl = new VerticalLayout();

                        final TextField text = new TextField("Remarks to the user");
                        text.setWidth("97%");
                        text.setHeight("150px");
                        vl.addComponent(text);

                        final Button okButton = new NativeButton();
                        okButton.setCaption("Save");
                        okButton.setImmediate(true);
                        okButton.setWidth("-1px");
                        okButton.setHeight("-1px");
                        okButton.addListener(new Button.ClickListener() {
                            public void buttonClick(ClickEvent event) {
                                long dbId = processingStatus.getProcessing().getDbId();
                                long userID = processingStatus.getProcessing().getUsers().iterator().next().getDbId();
                                long liferayID = app.getLiferayId(processingStatus.getProcessing().getUsers().iterator().next().getLiferayID());
                                processingService.markFailed(submissionIO.getSubmission().getDbId(), (String) text.getValue());
                                processingStatus = processingService.getProcessingStatus(userDataService.getProcessing(dbId), userID, liferayID, false);
                                refreshButton.setData(processingStatus);
                                processingStatusForm.fireValueChange(false);//fireEvent(new Event(refreshButton));
                                window.getParent().removeWindow(window);
                            }
                        });
                        vl.addComponent(okButton);
                        addComponent(vl);
                    }
                });
            }
        });
//		}

        remarksButton = new NativeButton("Why?");
        remarksButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                app.getMainWindow().addWindow(new Window() {
                    {
                        center();
                        setWidth("700px");
                        setHeight("500px");
                        VerticalLayout vl = new VerticalLayout();
                        vl.addComponent(new Label(processingService.getSubmissionError(submissionIO.getSubmission().getDbId()).getDescription(), Label.CONTENT_PREFORMATTED));
                        addComponent(vl);
                    }
                });
            }
        });
    }

    private String getStatus(String status, Error error, boolean testAdmin) {
        logger.info("1- " + status);
        if (testAdmin && !ProcessingStatus.Done.equalsString(status)) {
            status = (error != null && error.getMessage() != null) ? error.getMessage() : status;
        }
        logger.info("2- " + status);

        String color = null;
        if (status.contains(";")) {
            color = colorMap.get(";");
        } else if (ProcessingStatus.Done.equalsString(status)) {
            color = colorMap.get(ProcessingStatus.Done.toString());
        } else if (status.matches(".*([Ff]ailed|[Ee]rror|ERROR).*")) {
            color = colorMap.get(ProcessingStatus.On_Hold.toString());
        } else {
            color = colorMap.get(status.replaceAll("[0-9][0-9]*\\s*", ""));
        }
        if (color == null) {
            color = "#000000";
        }
        return "<span style='color: " + color + "'>" + (status != null ? status : "Unavailable") + "</span>";
    }

    @Override
    protected List<Component> createButtons() {
        List<Component> buttons = new ArrayList<Component>();
        final VaadinTestApplication app = (VaadinTestApplication) getApplication();

        refreshButton = new NativeButton();
        refreshButton.setCaption(REFRESH);
        refreshButton.setDescription("Refresh the status of this processing");
        refreshButton.setData(processingStatus);
        refreshButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                refreshButton.setData(processingStatus);
                userDataService.reopenSession();
                processingStatusForm.fireValueChange(false);//fireEvent(new Event(refreshButton));
            }
        });
        
        resumeAllButton = new NativeButton();
        resumeAllButton.setCaption(RESUME_ALL);
        resumeAllButton.setDescription("Resume all submissions that are on hold.");
//        resumeAllButton.setData(processingStatus);
        resumeAllButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                processingService.resubmit(processingStatus.getProcessing().getDbId());
                processingStatusForm.attach();
            }
        });        

//		this.refreshButton = refreshButton;

        cancelButton = new NativeButton();
        cancelButton.setCaption(CANCEL);
        cancelButton.setDescription("Cancel this processing");
        cancelButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                logger.debug("Cancel button is clicked.");
                processingService.markFailed(processingStatus.getProcessing().getDbId());
                processingStatusForm.fireValueChange(false);//fireEvent(new Event(refreshButton));
            }
        });

        deleteFilesButton = new NativeButton();
        deleteFilesButton.setCaption(DELETE_FILES);
        deleteFilesButton.setDescription("Delete the copies of input and output files related to this processing from the grid");
        deleteFilesButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                logger.debug("Delete Files button is clicked.");
                getApplication().getMainWindow().showNotification("Not implemented yet.");
            }
        });

        reportButton = new NativeButton();
        reportButton.setCaption(REPORT);
        reportButton.setDescription("Get a summary of what happened to this processing");
        reportButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                logger.debug("Report button is clicked.");
                final String htmlContent = userDataService.getProcessingReport(processingStatus.getProcessing().getDbId());
                showHTML(htmlContent, app);
            }
        });

        restartButton = new NativeButton();
        restartButton.setCaption(RESTART);
        restartButton.setDescription("Start a new processing to run the same application on the same data");
        restartButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                logger.debug("Restart button is clicked.");
                processingService.restart(processingStatus.getProcessing().getDbId());
                processingStatusForm.fireValueChange(false);//fireEvent(new Event(refreshButton));
            }
        });

        if (app == null) {
            System.out.println("app is null");
        } else if (app.getUserDataService() == null) {
            System.out.println("app user data service is null");
        } else if (app.isAdminURL() && app.getUserDataService().isNSGAdmin()) {
            refreshButton.setVisible(true);
            resumeAllButton.setVisible(true);
        } else {
            refreshButton.setVisible(false);
            resumeAllButton.setVisible(false);
        }
        
//                Label space = new Label("<div>&nbsp;</div>", Label.CONTENT_XHTML);
//                space.setWidth("100%");
//                space.setHeight("10px");
        buttons.add(refreshButton);
        buttons.add(resumeAllButton);
//        buttons.add(new Label("<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>", Label.CONTENT_XHTML));
//        buttons.add(cancelButton);
//                buttons.add(restartButton);
//                buttons.add(deleteFilesButton);
//                buttons.add(new Label("<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>", Label.CONTENT_XHTML));
//                buttons.add(reportButton);

        return buttons;
    }
}