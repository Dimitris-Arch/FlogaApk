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

 
clv2.AddTextItem("1801	ΚΑΤΗΓΟΡΙΑ 8	Οκτυλοτριχλωροσιλανίου	" ,"")   
clv2.AddTextItem("1802	ΚΑΤΗΓΟΡΙΑ 8	Υπερχλωρικό οξύ " ,"") 
clv2.AddTextItem("1803	ΚΑΤΗΓΟΡΙΑ 8	Φαινολοσουλφονικού οξέος , υγρό	" ,"")    
clv2.AddTextItem("1804	ΚΑΤΗΓΟΡΙΑ 8	Phenyltrichlorosilane	   " ,"") 
clv2.AddTextItem("1805	ΚΑΤΗΓΟΡΙΑ 8	Φωσφορικό οξύ	   " ,"") 
clv2.AddTextItem("1805	ΚΑΤΗΓΟΡΙΑ 8	Phosphorsure, fest	   " ,"") 
clv2.AddTextItem("1806	ΚΑΤΗΓΟΡΙΑ 8	Προστέθηκε πενταχλωριούχος φωσφόρος	   " ,"") 
clv2.AddTextItem("1807	ΚΑΤΗΓΟΡΙΑ 8	Πεντοξείδιο  φωσφόρου	   " ,"") 
clv2.AddTextItem("1808	ΚΑΤΗΓΟΡΙΑ 8	Φωσφόρο τριβρωμιούχο	   " ,"") 
clv2.AddTextItem("1809	ΚΑΤΗΓΟΡΙΑ 6.1	Τριχλωριούχος φωσφόρος	   " ,"") 
clv2.AddTextItem("1810	ΚΑΤΗΓΟΡΙΑ 8	Οξυχλωριούχου φωσφόρου	   " ,"") 
clv2.AddTextItem("1811	ΚΑΤΗΓΟΡΙΑ 8	Hydrogendifluoride κάλιο 	   " ,"") 
clv2.AddTextItem("1812	ΚΑΤΗΓΟΡΙΑ 8	Φθοριούχο κάλιο	  " ,"") 
clv2.AddTextItem("1813	ΚΑΤΗΓΟΡΙΑ 8	Υδροξείδιο  καλίου , στερεό	   " ,"") 
clv2.AddTextItem("1814	ΚΑΤΗΓΟΡΙΑ 8	Διάλυμα υδροξειδίου  καλίου	   " ,"") 
clv2.AddTextItem("1815	ΚΑΤΗΓΟΡΙΑ 3	Προπιονυλοχλωρίδιο	   " ,"") 
clv2.AddTextItem("1816	ΚΑΤΗΓΟΡΙΑ 8	Propyltrichlorosilane	   " ,"") 
clv2.AddTextItem("1817	ΚΑΤΗΓΟΡΙΑ 8	Pyrosulfuryl χλωριούχο	   " ,"") 
clv2.AddTextItem("1818	ΚΑΤΗΓΟΡΙΑ 8	Τετραχλωριούχου πυριτίου	   " ,"") 
clv2.AddTextItem("1819	ΚΑΤΗΓΟΡΙΑ 8	Αργιλικό νάτριο , διάλυμα	   " ,"") 
clv2.AddTextItem("1823	ΚΑΤΗΓΟΡΙΑ 8	Υδροξείδιο  νατρίου , στερεό	   " ,"") 
clv2.AddTextItem("1824	ΚΑΤΗΓΟΡΙΑ 8	Διάλυμα υδροξειδίου  νατρίου	   " ,"") 
clv2.AddTextItem("1825	ΚΑΤΗΓΟΡΙΑ 8	Μονοξείδιο  νατρίου	   " ,"") 
clv2.AddTextItem("1826	ΚΑΤΗΓΟΡΙΑ 8	Οξέος νίτρωσης μείγματα" ,"") 
clv2.AddTextItem("1827	ΚΑΤΗΓΟΡΙΑ 8	Χλωριούχου κασσιτέρου , άνυδρο	 " ,"")   
clv2.AddTextItem("1828	ΚΑΤΗΓΟΡΙΑ 8	Χλωρίδια θείου	   " ,"") 
clv2.AddTextItem("1829	ΚΑΤΗΓΟΡΙΑ 8	Τριοξείδιο  θείου ή τριοξείδιο  θείου	   " ,"") 
clv2.AddTextItem("1830	ΚΑΤΗΓΟΡΙΑ 8	Το θειικό οξύ με περισσότερο από 51 τοις εκατό οξύ	   " ,"") 
clv2.AddTextItem("1831	ΚΑΤΗΓΟΡΙΑ 8	Θειικό οξύ, ατμίζον" ,"") 
clv2.AddTextItem("1832	ΚΑΤΗΓΟΡΙΑ 8	Θειικό οξύ	   " ,"") 
clv2.AddTextItem("1833	ΚΑΤΗΓΟΡΙΑ 8	Θειώδες οξύ	   " ,"") 
clv2.AddTextItem("1834	ΚΑΤΗΓΟΡΙΑ 8	Σουλφουρυλο χλωρίδιο	" ,"")    
clv2.AddTextItem("1835	ΚΑΤΗΓΟΡΙΑ 8	Υδροξείδιο τετραμεθυλαμμωνίου	" ,"")    
clv2.AddTextItem("1836	ΚΑΤΗΓΟΡΙΑ 8	Θειονυλοχλωρίδιο	   " ,"") 
clv2.AddTextItem("1837	ΚΑΤΗΓΟΡΙΑ 8	Θειοφωσφορυλο χλωριούχο	   " ,"") 
clv2.AddTextItem("1838	ΚΑΤΗΓΟΡΙΑ 8	Τετραχλωριούχο τιτάνιο	   " ,"") 
clv2.AddTextItem("1839	ΚΑΤΗΓΟΡΙΑ 8	Τριχλωροξικό οξύ	   " ,"") 
clv2.AddTextItem("1840	ΚΑΤΗΓΟΡΙΑ 8	Χλωριούχου ψευδαργύρου , λύση	" ,"")    
clv2.AddTextItem("1841	ΚΑΤΗΓΟΡΙΑ 9	Η ακεταλδεΰδη αμμωνία	   " ,"") 
clv2.AddTextItem("1843	ΚΑΤΗΓΟΡΙΑ 6.1	Αμμώνιο dintro-ο-κρεζολικό	   " ,"") 
clv2.AddTextItem("1845	ΚΑΤΗΓΟΡΙΑ 9	Διοξείδιο  άνθρακα , στερεό, που ονομάζεται επίσης Ξηρός πάγος	 " ,"")   
clv2.AddTextItem("1846	ΚΑΤΗΓΟΡΙΑ 8	Τετραχλωράνθρακας	   " ,"") 
clv2.AddTextItem("1847	ΚΑΤΗΓΟΡΙΑ 8	Θειούχο κάλιο , ένυδρο	   " ,"") 
clv2.AddTextItem("1848	ΚΑΤΗΓΟΡΙΑ 8	Το προπιονικό οξύ	   " ,"") 
clv2.AddTextItem("1849	ΚΑΤΗΓΟΡΙΑ 6.1	Θειούχο νάτριο , ένυδρο με όχι λιγότερο από 30 τοις εκατό νερό" ,"") 	   
clv2.AddTextItem("1851	ΚΑΤΗΓΟΡΙΑ 6.1	Φάρμακο , υγρό, τοξικό, nos	   " ,"") 
clv2.AddTextItem("1854	ΚΑΤΗΓΟΡΙΑ 4.2	Βαρίου κράματα , πυροφορικά	   " ,"") 
clv2.AddTextItem("1855	ΚΑΤΗΓΟΡΙΑ 2	Ασβέστιο , πυροφορικά ή ασβεστίου κράματα, πυροφορικά	   " ,"") 
clv2.AddTextItem("1858	ΚΑΤΗΓΟΡΙΑ 2	Εξαφθωροπροπυλένιο , συμπιεσμένα ή ψυκτικό αέριο R 1216	   " ,"") 
clv2.AddTextItem("1859	ΚΑΤΗΓΟΡΙΑ 2	Τετραφθοριούχο πυρίτιο , συμπιεσμένο	   " ,"") 
clv2.AddTextItem("1860	ΚΑΤΗΓΟΡΙΑ 3	Φθοριούχο βινύλιο 	   " ,"") 
clv2.AddTextItem("1862	ΚΑΤΗΓΟΡΙΑ 3	Αιθύλιο κροτονικό	   " ,"") 
clv2.AddTextItem("1863	ΚΑΤΗΓΟΡΙΑ 3	Καυσίμων , αεροπορία, στροβιλοκινητήρα	   " ,"") 
clv2.AddTextItem("1865	ΚΑΤΗΓΟΡΙΑ 3	Νιτρικό Ν-Προπυλ	   " ,"") 
clv2.AddTextItem("1866	ΚΑΤΗΓΟΡΙΑ 3	Διάλυμα ρητίνης, εύφλεκτο	   " ,"") 
clv2.AddTextItem("1868	ΚΑΤΗΓΟΡΙΑ 4.1	Δεκαβοράνιο	   " ,"") 
clv2.AddTextItem("1869	ΚΑΤΗΓΟΡΙΑ 4.3	Μαγνήσιο ή κράματα μαγνησίου, ρινίσματα, ή κορδέλες	" ,"")    
clv2.AddTextItem("1870	ΚΑΤΗΓΟΡΙΑ 4.1	Βοροϋδριδίου  καλίου	   " ,"") 
clv2.AddTextItem("1871	ΚΑΤΗΓΟΡΙΑ 5.1	Υδριδίου  τιτανίου	   " ,"") 
clv2.AddTextItem("1872	ΚΑΤΗΓΟΡΙΑ 5.1	Διοξείδιο  μολύβδου	   " ,"") 
clv2.AddTextItem("1873	ΚΑΤΗΓΟΡΙΑ 6.1	Υπερχλωρικό οξύ 	   " ,"") 
clv2.AddTextItem("1884	ΚΑΤΗΓΟΡΙΑ 6.1	Οξείδιο  βαρίου	   " ,"") 
clv2.AddTextItem("1885	ΚΑΤΗΓΟΡΙΑ 6.1	Βενζιδίνη	   " ,"") 
clv2.AddTextItem("1886	ΚΑΤΗΓΟΡΙΑ 6.1	Βενζυλιδεν χλωριούχο	" ,"")    
clv2.AddTextItem("1887	ΚΑΤΗΓΟΡΙΑ 6.1	Βρωμοχλωρομεθάνιο	" ,"")    
clv2.AddTextItem("1888	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροφόρμιο	   " ,"") 
clv2.AddTextItem("1889	ΚΑΤΗΓΟΡΙΑ 6.1	Βρωμιούχο κυάνιο	   " ,"") 
clv2.AddTextItem("1891	ΚΑΤΗΓΟΡΙΑ 6.1	Βρωμιούχο αιθύλιο	   " ,"") 
clv2.AddTextItem("1892	ΚΑΤΗΓΟΡΙΑ 6.1	Αιθυλοδιχλωροαρσίνη	   " ,"") 
clv2.AddTextItem("1894	ΚΑΤΗΓΟΡΙΑ 6.1	Φαινυλυδράργυρο υδροξείδιο	   " ,"") 
clv2.AddTextItem("1895	ΚΑΤΗΓΟΡΙΑ 6.1	Νιτρικός φαινυλυδράργυρος	   " ,"") 
clv2.AddTextItem("1897	ΚΑΤΗΓΟΡΙΑ 6.1	Tetrachloroethylene	   " ,"") 
clv2.AddTextItem("1898	ΚΑΤΗΓΟΡΙΑ 8	Ακετυλο ιωδίδιο" ,"") 

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

