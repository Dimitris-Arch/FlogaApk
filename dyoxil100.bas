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

 
clv2.AddTextItem("2001	Κατηγορία 4.1	Ναφθενικά κοβαλτίου , σε σκόνη	   ", "")
clv2.AddTextItem("2002	Κατηγορία 4.2	Ταρταρούγα , ξύστε	   ", "")
clv2.AddTextItem("2003	Κατηγορία 4.2	Μεταλλικά αλκύλια , αντιδρώντα με νερό, ε.α.ο. ή αρύλια μετάλλων, αντιδρώντα με νερό, ε.α.ο.	   ", "")
clv2.AddTextItem("2004	Κατηγορία 4.2	Διαμιδο μαγνήσιο	   ", "")
clv2.AddTextItem("2005	Κατηγορία 4.2	Διφαινυλαιθέρες μαγνήσιο	     ", "")
clv2.AddTextItem("2006	Κατηγορία 4.2	Πλαστικά , νιτροκυτταρίνη που βασίζονται, αυτο-θέρμανσης, ε.α.ο.	   ", "")
clv2.AddTextItem("2008	Κατηγορία 4.2	Ζιρκόνιο σε σκόνη, ξηρό	   ", "")
clv2.AddTextItem("2009	Κατηγορία 4.2	Ζιρκόνιο, ξηρό, τα τελικά φύλλα, ταινίες ή τυλιγμένου σύρματος	   ", "")
clv2.AddTextItem("2010	Κατηγορία 4.3	Υδρίδιο  μαγνησίου	   ", "")
clv2.AddTextItem("2011	Κατηγορία 4.3	Φωσφορούχο μαγνήσιο	   ", "")
clv2.AddTextItem("2012	Κατηγορία 4.3	Φωσφορούχο κάλιο	   ", "")
clv2.AddTextItem("2013	Κατηγορία 4.3	Στρόντιο φωσφορούχο	   ", "")
clv2.AddTextItem("2014	Κατηγορία 5.1	Υπεροξείδιο  υδρογόνου	   ", "")
clv2.AddTextItem("2016	Κατηγορία 6.1	Πυρομαχικά , τοξικά, μη-εκρηκτικά χωρίς ρήγμα ή διαρροή γόμωσης, μη-τηγμένου	   ", "")
clv2.AddTextItem("2017	Κατηγορία 6.1	Πυρομαχικά, δακρυγόνο, μη-εκρηκτικά χωρίς ρήγμα ή διαρροή γόμωσης, μη-τηγμένου	   ", "")
clv2.AddTextItem("2018	Κατηγορία 6.1	Χλωροανιλίνες , στερεά	   ", "")
clv2.AddTextItem("2019	Κατηγορία 6.1	Χλωροανιλίνες, υγρό	   ", "")
clv2.AddTextItem("2020	Κατηγορία 6.1	Χλωροφαινόλες , στερεά	   ", "")
clv2.AddTextItem("2021	Κατηγορία 6.1	Χλωροφαινόλες, υγρό	   ", "")
clv2.AddTextItem("2022	Κατηγορία 6.1	Κρεσόλη	   ", "")
clv2.AddTextItem("2023	Κατηγορία 6.1	Επιχλωρυδρίνη	   ", "")
clv2.AddTextItem("2024	Κατηγορία 6.1	Υδράργυρος ενώσεις, υγρό, ε.α.ο.	   ", "")
clv2.AddTextItem("2025	Κατηγορία 6.1	Οι ενώσεις υδραργύρου, στερεές, ε.α.ο.	   ", "")
clv2.AddTextItem("2026	Κατηγορία 6.1	Φαινυλυδράργυρο ενώσεις, ε.α.ο.	   ", "")
clv2.AddTextItem("2027	Κατηγορία 6.1	Arsenite νατρίου , στερεό	   ", "")
clv2.AddTextItem("2028	Κατηγορία 8	Βόμβες , καπνός, μη-εκρηκτικά, με διαβρωτικό υγρό, χωρίς συσκευή έναρξη", "")	   
clv2.AddTextItem("2029	Κατηγορία 8	Υδραζίνη , άνυδρη	   ", "")
clv2.AddTextItem("2030	Κατηγορία 8	Η υδραζίνη υδατικό διάλυμα, με περισσότερο από 37 τοις εκατό υδραζίνη, κατά μάζα	", "")   
clv2.AddTextItem("2031	Κατηγορία 8	Νιτρικό οξύ , εκτός από  κόκκινο ατμίζον", "")
clv2.AddTextItem("2032	Κατηγορία 8	Το νιτρικό οξύ, ερυθρό ατμίζον	   ", "")
clv2.AddTextItem("2033	Κατηγορία 8	Μονοξείδιο  καλίου	   ", "")
clv2.AddTextItem("2034	Κατηγορία 2	Υδρογόνο και μεθάνιο μείγματα, συμπιεσμένο	  ", "") 
clv2.AddTextItem("2035	Κατηγορία 2	Κατηγορία 1,Κατηγορία 1,Κατηγορία 1-τριφθοροαιθάνιο , Ε 143α συμπιεσμένο ή ψυκτικό αέριο", "")	   
clv2.AddTextItem("2036	Κατηγορία 2	Προβολείς Xenon , συμπιεσμένο	   ", "")
clv2.AddTextItem("2037	Κατηγορία 2	Φυσίγγια αερίου (εύφλεκτο) χωρίς συσκευή απελευθέρωσης", "")
clv2.AddTextItem("2038	Κατηγορία 6.1	Dinitrotoluenes , υγρό ή Dinitrotoluenes, στερεά	   ", "")
clv2.AddTextItem("2044	Κατηγορία 2	Κατηγορία 2,Κατηγορία 2-διμεθυλπροπάνιο	   ", "")
clv2.AddTextItem("2045	Κατηγορία 3	Ισοβουτυραλδεΰδη ή ισοβουτυλαλδεΰδη	   ", "")
clv2.AddTextItem("2046	Κατηγορία 3	Cymenes	   ", "")
clv2.AddTextItem("2047	Κατηγορία 3	Dichloropropenes", "")	   
clv2.AddTextItem("2048	Κατηγορία 3	Δικυκλοπενταδιένιο	   ", "")
clv2.AddTextItem("2049	Κατηγορία 3	Διαιθυλβενζολίου	   ", "")
clv2.AddTextItem("2050	Κατηγορία 3	Διϊσοβουτυλένιο , ισομερείς ενώσεις", "")	   
clv2.AddTextItem("2051	Κατηγορία 8	Κατηγορία 2-διμεθυλαμινοαιθανόλη	", "")   
clv2.AddTextItem("2052	Κατηγορία 3	Διπεντενίου	   ", "")
clv2.AddTextItem("2053	Κατηγορία 3	Μεθυλο-ισοβουτυλο-καρβινόλη", "")	   
clv2.AddTextItem("2054	Κατηγορία 3	Μορφολίνη	   ", "")
clv2.AddTextItem("2055	Κατηγορία 8	Το στυρένιο μονομερές, αναστέλλεται", "")	   
clv2.AddTextItem("2056	Κατηγορία 3	Τετραϋδροφουράνη	   ", "")
clv2.AddTextItem("2057	Κατηγορία 3	Τριπροπυλενίου	   ", "")
clv2.AddTextItem("2058	Κατηγορία 3	Βαλεραλδεΰδη	   ", "")
clv2.AddTextItem("2059	Κατηγορία 3	Νιτροκυτταρίνη, διάλυμα, εύφλεκτο με όχι λιγότερο από 12%", "")
clv2.AddTextItem("2074	Κατηγορία 6.1	Το ακρυλαμίδιο , Στερεά	   ", "")
clv2.AddTextItem("2075	Κατηγορία 6.1	Χλωράλη , άνυδρο, αναστέλλεται	", "")   
clv2.AddTextItem("2076	Κατηγορία 6.1	Κρεζόλες	   ", "")
clv2.AddTextItem("2077	Κατηγορία 6.1	άλφα-ναφθιλαμίνη	", "")   
clv2.AddTextItem("2078	Κατηγορία 6.1	Διισοκυανικό τολουόλιο", "")	   
clv2.AddTextItem("2079	Κατηγορία 8	Diethylenetriamine	 ", "")

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
