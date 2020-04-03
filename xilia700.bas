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

 
clv2.AddTextItem("1601	ΚΑΤΗΓΟΡΙΑ 6.1	Απολυμαντικά , στερεά, τοξικά, ", "")
clv2.AddTextItem("1602	ΚΑΤΗΓΟΡΙΑ 6.1	Βαφές , υγρά, τοξικά	   ", "")
clv2.AddTextItem("1603	ΚΑΤΗΓΟΡΙΑ 6.1	Αιθυλ βρωμοοξικό	   ", "")
clv2.AddTextItem("1604	ΚΑΤΗΓΟΡΙΑ 8	Αιθυλενοδιαμίνης	   ", "")
clv2.AddTextItem("1605	ΚΑΤΗΓΟΡΙΑ 6.1	Αιθυλενοδιβρωμιδίου	   ", "")
clv2.AddTextItem("1606	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικός σίδηρος	   ", "")
clv2.AddTextItem("1607	ΚΑΤΗΓΟΡΙΑ 6.1	Σίδηρος arsenite	   ", "")
clv2.AddTextItem("1608	ΚΑΤΗΓΟΡΙΑ 6.1	Σιδηρούχα Αρσενικικό	   ", "")
clv2.AddTextItem("1611	ΚΑΤΗΓΟΡΙΑ 6.1	Hexaethyl τετραφωσφορεστέρα 	   ", "")
clv2.AddTextItem("1612	ΚΑΤΗΓΟΡΙΑ 2	Hexaethyl τετραφωσφορικό και μείγματα    ", "")
clv2.AddTextItem("1613	ΚΑΤΗΓΟΡΙΑ 6.1	Υδροκυάνιο ", "")
clv2.AddTextItem("1614	ΚΑΤΗΓΟΡΙΑ 6.1	Υδροκυάνιο , σταθεροποιημένο   ", "")
clv2.AddTextItem("1616	ΚΑΤΗΓΟΡΙΑ 6.1	Οξικός μόλυβδος	   ", "")
clv2.AddTextItem("1617	ΚΑΤΗΓΟΡΙΑ 6.1	Μόλυβδος αρσενικικών	   ", "")
clv2.AddTextItem("1618	ΚΑΤΗΓΟΡΙΑ 6.1	Μόλυβδος αρσενιάτες	   ", "")
clv2.AddTextItem("1620	ΚΑΤΗΓΟΡΙΑ 6.1	Μόλυβδος κυανίου	   ", "")
clv2.AddTextItem("1621	ΚΑΤΗΓΟΡΙΑ 6.1	Λονδίνο μωβ	   ", "")
clv2.AddTextItem("1622	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικό μαγνήσιο	   ", "")
clv2.AddTextItem("1623	ΚΑΤΗΓΟΡΙΑ 6.1	Υδράργυρος Αρσενικικό	   ", "")
clv2.AddTextItem("1624	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωριούχο υδράργυρο	   ", "")
clv2.AddTextItem("1625	ΚΑΤΗΓΟΡΙΑ 6.1	Νιτρικό υδράργυρο	   ", "")
clv2.AddTextItem("1626	ΚΑΤΗΓΟΡΙΑ 6.1	Υδραργύρου κυανιούχο κάλιο	   ", "")
clv2.AddTextItem("1627	ΚΑΤΗΓΟΡΙΑ 6.1	Νιτρικού υδραργύρου	   ", "")
clv2.AddTextItem("1629	ΚΑΤΗΓΟΡΙΑ 6.1	Από οξικό υδράργυρο	   ", "")
clv2.AddTextItem("1630	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος χλωριούχο αμμώνιο	", "")   
clv2.AddTextItem("1631	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος βενζοϊκό	   ", "")
clv2.AddTextItem("1634	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος βρωμιούχα	   ", "")
clv2.AddTextItem("1636	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος κυανίου	", "")
clv2.AddTextItem("1637	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος γλυκονικό	   ", "")
clv2.AddTextItem("1638	ΚΑΤΗΓΟΡΙΑ 6.1	Ιωδιούχο υδράργυρος 	   ", "")
clv2.AddTextItem("1639	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος nucleate	   ", "")
clv2.AddTextItem("1640	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος ελαϊκό	   ", "")
clv2.AddTextItem("1641	ΚΑΤΗΓΟΡΙΑ 6.1	Οξειδίου  υδραργύρου	   ", "")
clv2.AddTextItem("1642	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος οξυκυανιούχος	   ", "")
clv2.AddTextItem("1643 	ΚΑΤΗΓΟΡΙΑ 6.1	Ιωδιούχο κάλιο υδράργυρος	   ", "")
clv2.AddTextItem("1644	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος σαλικυλικό	   ", "")
clv2.AddTextItem("1645	ΚΑΤΗΓΟΡΙΑ 6.1	Θειικά υδράργυρος	   ", "")
clv2.AddTextItem("1646	ΚΑΤΗΓΟΡΙΑ 6.1	Ο υδράργυρος θειοκυανικός	   ", "")
clv2.AddTextItem("1647	ΚΑΤΗΓΟΡΙΑ 6.1	Το βρωμιούχο μεθύλιο και αιθυλενοδιβρωμίδιο μείγματα   ", "")
clv2.AddTextItem("1648	ΚΑΤΗΓΟΡΙΑ 3	Ακετονιτρίλιο	   ", "")
clv2.AddTextItem("1649	ΚΑΤΗΓΟΡΙΑ 6.1	Motor καυσίμου μείγματα    ", "")
clv2.AddTextItem("1650	ΚΑΤΗΓΟΡΙΑ 6.1	βήτα-ναφθιλαμίνη	   ", "")
clv2.AddTextItem("1651	ΚΑΤΗΓΟΡΙΑ 6.1	Ναφθυλοθειοουρία	   ", "")
clv2.AddTextItem("1652	ΚΑΤΗΓΟΡΙΑ 6.1	Ναφθυλουρίας	   ", "")
clv2.AddTextItem("1653	ΚΑΤΗΓΟΡΙΑ 6.1	Νικέλιο κυανίου	   ", "")
clv2.AddTextItem("1654	ΚΑΤΗΓΟΡΙΑ 6.1	Νικοτίνη	   ", "")
clv2.AddTextItem("1655	ΚΑΤΗΓΟΡΙΑ 6.1	Νικοτίνη ενώσεις	   ", "")
clv2.AddTextItem("1656	ΚΑΤΗΓΟΡΙΑ 6.1	Υδροχλωρική νικοτίνη ή διάλυμα υδροχλωρικής νικοτίνης	   ", "")
clv2.AddTextItem("1657	ΚΑΤΗΓΟΡΙΑ 6.1	Σαλικυλική νικοτίνη	   ", "")
clv2.AddTextItem("1658	ΚΑΤΗΓΟΡΙΑ 6.1	Θειική νικοτίνη , στερεά ή θειική νικοτίνη, διάλυμα	   ", "")
clv2.AddTextItem("1659	ΚΑΤΗΓΟΡΙΑ 6.1	Τρυγική νικοτίνη	   ", "")
clv2.AddTextItem("1660	ΚΑΤΗΓΟΡΙΑ 2	Οξείδιο  αζώ , συμπιεσμένο	   ", "")
clv2.AddTextItem("1661	ΚΑΤΗΓΟΡΙΑ 6.1	Νιτροανιλινών  ", "")
clv2.AddTextItem("1662	ΚΑΤΗΓΟΡΙΑ 6.1	Νιτροβενζόλιο	   ", "")
clv2.AddTextItem("1663	ΚΑΤΗΓΟΡΙΑ 6.1	Νιτροφαινολών 	   ", "")
clv2.AddTextItem("1664	ΚΑΤΗΓΟΡΙΑ 6.1	Νιτροτολουόλια 	   ", "")
clv2.AddTextItem("1665	ΚΑΤΗΓΟΡΙΑ 6.1	Nitroxylenes	   ", "")
clv2.AddTextItem("1669	ΚΑΤΗΓΟΡΙΑ 6.1	Πενταχλωροαιθάνιο	   ", "")
clv2.AddTextItem("1670	ΚΑΤΗΓΟΡΙΑ 6.1	Υπερχλωρομεθύλιο μερκαπτάνη", "")	   
clv2.AddTextItem("1671	ΚΑΤΗΓΟΡΙΑ 6.1	Η φαινόλη , στερεά	   ", "")
clv2.AddTextItem("1672	ΚΑΤΗΓΟΡΙΑ 6.1	Phenylcarbylamine χλωριούχο	   ", "")
clv2.AddTextItem("1673	ΚΑΤΗΓΟΡΙΑ 6.1	Φαινυλενοδιαμίνες	   ", "")
clv2.AddTextItem("1674	ΚΑΤΗΓΟΡΙΑ 6.1	Οξικός φαινυλυδράργυρος	   ", "")
clv2.AddTextItem("1677	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικό κάλιο	   ", "")
clv2.AddTextItem("1678	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικώδους κάλιο	   ", "")
clv2.AddTextItem("1679	ΚΑΤΗΓΟΡΙΑ 6.1	Cuprocyanide κάλιο	   ", "")
clv2.AddTextItem("1680	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχο κάλιο	   ", "")
clv2.AddTextItem("1683	ΚΑΤΗΓΟΡΙΑ 6.1	Ασημένια arsenite	   ", "")
clv2.AddTextItem("1684	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχου αργύρου	   ", "")
clv2.AddTextItem("1685	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικού νατρίου	   ", "")
clv2.AddTextItem("1686	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικώδες νάτριο , υδατικά διαλύματα	   ", "")
clv2.AddTextItem("1687	ΚΑΤΗΓΟΡΙΑ 6.1	Το αζίδιο  νατρίου	   ", "")
clv2.AddTextItem("1688	ΚΑΤΗΓΟΡΙΑ 6.1	Κακοδυλικό νάτριο	   ", "")
clv2.AddTextItem("1689	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχο νάτριο	   ", "")
clv2.AddTextItem("1690	ΚΑΤΗΓΟΡΙΑ 6.1	Φθοριούχο νάτριο	   ", "")
clv2.AddTextItem("1691	ΚΑΤΗΓΟΡΙΑ 6.1	Στρόντιο αρσενιατικού	   ", "")
clv2.AddTextItem("1692	ΚΑΤΗΓΟΡΙΑ 6.1	Στρυχνίνη ή στρυχνίνη άλατα	   ", "")
clv2.AddTextItem("1693	ΚΑΤΗΓΟΡΙΑ 6.1	Δακρυγόνα ουσίες, υγρά 	   ", "")
clv2.AddTextItem("1694	ΚΑΤΗΓΟΡΙΑ 6.1	Βρωμοβενζυλο κυανιούχα    ", "")
clv2.AddTextItem("1695	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροακετόνης , σταθεροποιημένο	", "")   
clv2.AddTextItem("1697	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροακετοφαινόνης 	   ", "")
clv2.AddTextItem("1698	ΚΑΤΗΓΟΡΙΑ 6.1	Diphenylaminechloroarsine	   ", "")
clv2.AddTextItem("1699	ΚΑΤΗΓΟΡΙΑ 6.1	Diphenylchloroarsine	", "")   	 

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
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
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
