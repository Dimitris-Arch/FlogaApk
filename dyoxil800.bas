B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
Dim sc As ScrollView
Dim ili As Button
Dim ousia As Button
Dim simansi As Button
Dim pixi As Button

Dim lista As Button

	Private katigor As Button
	
	Dim fakos As Label
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label






	Dim Panel As Panel

	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("adr.bal")

		
		
 simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x



''PANW DEXIA MESH
lista.Top = 3%y
lista.left = 51.5%x
lista.height = 13%y
lista.Width  = 21.25%x

listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x



katigor.Top = 18%y
katigor.left = 51.50%x
katigor.height = 13%y
katigor.Width  = 21.25%x

katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH
ousia.Top = 3%y
ousia.left = 75.75%x
ousia.height = 13%y
ousia.Width  = 21.25%x
ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x

ili.Top = 18%y
ili.left = 75.75%x
ili.height = 13%y
ili.Width  = 21.25%x
ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y


	
	

	
	
	
	
  
  
clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray

 
clv2.AddTextItem("2705	Κατηγορία 8	Κατηγορία 1-πεντόλης	    " ,"")
clv2.AddTextItem("2707	Κατηγορία 3	Dimethyldioxanes	    " ,"")
clv2.AddTextItem("2709	Κατηγορία 3	Βουτύλιο βενζένια	    " ,"")
clv2.AddTextItem("2710	Κατηγορία 3	Διπροπυλο κετόνη	    " ,"")
clv2.AddTextItem("2713	Κατηγορία 6.1	Ακριδίνη	    " ,"")
clv2.AddTextItem("2714	Κατηγορία 4.1	Αβιετικός ψευδαργύρου	    " ,"")
clv2.AddTextItem("2715	Κατηγορία 4.1	Αβιετικός Αλουμινίου	    " ,"")
clv2.AddTextItem("2716	Κατηγορία 6.1	Butynediol	    " ,"")
clv2.AddTextItem("2717	Κατηγορία 4.1	Καμφορά , συνθετική	 " ,"")
clv2.AddTextItem("2719	Κατηγορία 5.1	Βάριο βρωμικό	    " ,"")
clv2.AddTextItem("2720	Κατηγορία 5.1	Νιτρικό χρώμιο	    " ,"")
clv2.AddTextItem("2721	Κατηγορία 5.1	Χλωρικό χαλκού	    " ,"")
clv2.AddTextItem("2722	Κατηγορία 5.1	Νιτρικό λίθιο	 " ,"")   
clv2.AddTextItem("2723	Κατηγορία 5.1	Χλωρικό μαγνήσιο	    " ,"")
clv2.AddTextItem("2724	Κατηγορία 5.1	Μαγγάνιο νιτρικό	    " ,"")
clv2.AddTextItem("2725	Κατηγορία 5.1	Νιτρικού νικελίου	    " ,"")
clv2.AddTextItem("2726	Κατηγορία 5.1	Νιτρώδες νικελίου	    " ,"")
clv2.AddTextItem("2727	Κατηγορία 6.1	Νιτρικό θάλλιο	    " ,"")
clv2.AddTextItem("2728	Κατηγορία 5.1	Νιτρικό ζιρκόνιο	    " ,"")
clv2.AddTextItem("2729	Κατηγορία 6.1	Εξαχλωροβενζόλιο	    " ,"")
clv2.AddTextItem("2730	Κατηγορία 6.1	Νιτροανισόλης	    " ,"")
clv2.AddTextItem("2732	Κατηγορία 6.1	Nitrobromobenzenes υγρά ή στερεά Nitrobromobenzenes	   " ,"") 
clv2.AddTextItem("2733	Κατηγορία 3	Αμίνες , εύφλεκτα, διαβρωτικά, ε.α.ο. ή πολυαμίνες, εύφλεκτες, διαβρωτικές, ε.α.ο.	 " ,"")   
clv2.AddTextItem("2734	Κατηγορία 8	Αμίνες, υγρά, διαβρωτικά, εύφλεκτα, ε.α.ο. ή πολυαμίνες, υγρές, διαβρωτικές, εύφλεκτες, ε.α.ο.	 " ,"")   
clv2.AddTextItem("2735	Κατηγορία 8	Αμίνες, υγρά, διαβρωτικά, ε.α.ο. ή πολυαμίνες, υγρές, διαβρωτικές, ε.α.ο.	    " ,"")
clv2.AddTextItem("2739	Κατηγορία 8.1	Βουτυρικού ανυδρίτη	    " ,"")
clv2.AddTextItem("2740	Κατηγορία 6.1	χλωρομυρμηκικού κ-προπυλεστέρα	    " ,"")
clv2.AddTextItem("2741	Κατηγορία 5.1	Βάριο υποχλωριώδες με περισσότερα από 22 τοις εκατό διαθέσιμο χλώριο	 " ,"")   
clv2.AddTextItem("2742	Κατηγορία 6.1	Χλωρομυρμηκικούς , τοξικά, διαβρωτικά, εύφλεκτα " ,"")   
clv2.AddTextItem("2743	Κατηγορία 6.1	χλωροφορμικό η-Βουτυλ	    " ,"")
clv2.AddTextItem("2744	Κατηγορία 6.1	Χλωροφορμικό Κυκλοβουτυλο	    " ,"")
clv2.AddTextItem("2745	Κατηγορία 6.1	Χλωροφορμικό χλωρομεθύλιο	    " ,"")
clv2.AddTextItem("2746	Κατηγορία 6.1	Φαινυλ-χλωροφορμικό	    " ,"")
clv2.AddTextItem("2747	Κατηγορία 6.1	τριτο-Butylcyclohexylchloroformate	    " ,"")
clv2.AddTextItem("2748	Κατηγορία 6.1	Χλωρομυρμηκικού Κατηγορία 2-αιθυλεξυλεστέρα	   " ,"") 
clv2.AddTextItem("2749	Κατηγορία 3	Τετραμεθυλσιλανίου	    " ,"")
clv2.AddTextItem("2750	Κατηγορία 6.1	Κατηγορία 1,Κατηγορία 3-διχλωροπροπαν-Κατηγορία 2-όλη	      " ,"") 
clv2.AddTextItem("2751	Κατηγορία 8	Διαιθυλθειοφωσφορυλ χλωριούχο	      " ,"") 
clv2.AddTextItem("2752	Κατηγορία 3	Κατηγορία 1,Κατηγορία 2-εποξυ-Κατηγορία 3-ethoxypropane	      " ,"") 
clv2.AddTextItem("2753	Κατηγορία 6.1	Ν-Ethylbenzyltoluidines υγρό ή Ν-Ethylbenzyltoluidines στερεά	   " ,"")    
clv2.AddTextItem("2754	Κατηγορία 6.1	Ν-Ethyltoluidines	      " ,"") 
clv2.AddTextItem("2757	Κατηγορία 6.1	Καρβαμιδικό παρασιτοκτόνα , στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2758	Κατηγορία 3	Καρβαμιδικό παρασιτοκτόνα, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	      " ,"") 
clv2.AddTextItem("2759	Κατηγορία 6.1	Αρσενικού παρασιτοκτόνα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2760	Κατηγορία 3	Αρσενικού παρασιτοκτόνα, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	     " ,"")  
clv2.AddTextItem("2761	Κατηγορία 6.1	Οργανοχλωριωμένα παρασιτοκτόνα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2762	Κατηγορία 3	Οργανοχλωριωμένα παρασιτοκτόνα υγρό, εύφλεκτο, τοξικό, σημείο ανάφλεξης μικρότερο από 23 ° C	   " ,"")    
clv2.AddTextItem("2763	Κατηγορία 6.1	Τριαζίνης παρασιτοκτόνα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2764	Κατηγορία 3	Παρασιτοκτόνα τριαζίνης, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	      " ,"") 
clv2.AddTextItem("2771	Κατηγορία 6.1	Θειοκαρβαμικού παρασιτοκτόνα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2772	Κατηγορία 3	Θειοκαρβαμιδικό παρασιτοκτόνο, υγρό, εύφλεκτο, τοξικό, σημείο ανάφλεξης μικρότερο από 23 ° C	   " ,"")    
clv2.AddTextItem("2775	Κατηγορία 6.1	Χαλκός φυτοφάρμακα βάση, στερεά, τοξικά	         " ,"") 
clv2.AddTextItem("2776	Κατηγορία 3	Χαλκός φυτοφάρμακα βάση, υγρό, εύφλεκτο, τοξικό, σημείο ανάφλεξης μικρότερο από 23 ° C	      " ,"") 
clv2.AddTextItem("2777	Κατηγορία 6.1	Ο υδράργυρος φυτοφάρμακα που βασίζονται, στερεά, τοξικά	         " ,"") 
clv2.AddTextItem("2778	Κατηγορία 3	Ο υδράργυρος φυτοφάρμακα που βασίζονται, υγρό, εύφλεκτο, τοξικό, σημείο ανάφλεξης μικρότερο από 23 ° C	   " ,"")    
clv2.AddTextItem("2779	Κατηγορία 6.1	Υποκαταστημένα νιτροφαινόλη φυτοφάρμακα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2780	Κατηγορία 3	Υποκατεστημένοι φυτοφάρμακα νιτροφαινόλης, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	   " ,"")    
clv2.AddTextItem("2781	Κατηγορία 6.1	Bipyridilium παρασιτοκτόνα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2782	Κατηγορία 3	Bipyridilium παρασιτοκτόνα, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	      " ,"") 
clv2.AddTextItem("2783	Κατηγορία 6.1	Οργανοφωσφορικές φυτοφάρμακα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2784	Κατηγορία 3	Οργανοφωσφορικές φυτοφάρμακα, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	   " ,"")    
clv2.AddTextItem("2785	Κατηγορία 6.1	Thiapentanal	      " ,"") 
clv2.AddTextItem("2786	Κατηγορία 6.1	Οργανοκασσιτερικές φυτοφάρμακα, στερεά, τοξικά	      " ,"") 
clv2.AddTextItem("2787	Κατηγορία 6.1	Οργανοκασσιτερικές φυτοφάρμακα, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	   " ,"")    
clv2.AddTextItem("2788	Κατηγορία 6.1	Οργανοκασσιτερικές ενώσεις, υγρές, ε.α.ο.	      " ,"") 
clv2.AddTextItem("2789	Κατηγορία 8	Οξικό οξύ , παγόμορφο διάλυμα ή οξικό οξύ, με περισσότερο από 80 τοις εκατό οξύ, κατά βάρος	   " ,"")    
clv2.AddTextItem("2790	Κατηγορία 8	Διάλυμα οξικού οξέος, όχι λιγότερο από 50 τοις εκατό αλλά όχι περισσότερο από 80 τοις εκατό οξύ,   " ,"") 
clv2.AddTextItem("2793	Κατηγορία 4.2	Σιδηρούχων μετάλλων    " ,"") 
clv2.AddTextItem("2794	Κατηγορία 8	Μπαταρίες , υγρό, γεμάτο με οξύ, ηλεκτρικής συσσώρευσης	      " ,"") 
clv2.AddTextItem("2795	Κατηγορία 8	Μπαταρίες, υγρό, γεμάτο με αλκάλια, ηλεκτρική αποθήκευση	      " ,"") 
clv2.AddTextItem("2796	Κατηγορία 8	Υγρό μπαταρίας, οξύ ή θειικό οξύ με όχι περισσότερο από 51 τοις εκατό οξύ	   " ,"")    
clv2.AddTextItem("2797	Κατηγορία 8	Το υγρό της μπαταρίας, αλκαλικά	      " ,"") 
clv2.AddTextItem("2798	Κατηγορία 8	Phenylphosphorus Διχλωριδίου	      " ,"") 
clv2.AddTextItem("2799	Κατηγορία 8	Phenylphosphorus Thiodichloride	      " ,"") 
 clv2.AddTextItem("2800	Κατηγορία 8	Μπαταρίες, υγρή, μη διαρροή, ηλεκτρικής συσσώρευσης   " ,"") 

End Sub

Sub clv1_ItemClick (Index As Int, Value As Object)
	Activity.Title = Value
End Sub

Sub CreateListItem(Text As String, Width As Int, Height As Int) As Panel
	Dim p As Panel
	p.Initialize("")
	p.Color = Colors.Black
	Dim b As Button
	b.Initialize("button") 'all buttons click events will be handled with Sub Button_Click
	Dim chk As CheckBox
	chk.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.OR(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	lbl.Text = Text
	lbl.TextSize = 16
	lbl.TextColor = Colors.White
	b.Text = "Click"
	p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip) 'view #0
	p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip) 'view #1
	p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip) 'view #2
	Return p
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub

Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simansi_Click
	StartActivity("Main")
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub

