import React, { useState } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import { MaterialSideBarData } from "./MaterialSideBarData";
import SubMenu from "./SubMenu";
import { IconContext } from "react-icons";
import MaterialTable from "./MaterialTable"; // Import the table

const Nav = styled.div`
  background: #15171c;
  height: 80px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;

const NavIcon = styled(Link)`
  margin-left: 2rem;
  font-size: 2rem;
  height: 80px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;

const SidebarNav = styled.nav`
  background: #15171c;
  width: 250px;
  height: 100vh;
  display: flex;
  justify-content: center;
  position: fixed;
  top: 0;
  left: ${({ sidebar }) => (sidebar ? '0' : '-100%')};
  transition: 350ms;
  z-index: 10;
`;

const SidebarWrap = styled.div`
  width: 100%;
`;

const ContentArea = styled.div`
  margin-left: 260px;
  padding: 20px;
  background: #5c5c5c;
  min-height: 100vh;
`;

const MaterialSideBar = () => {
    const [sidebar, setSidebar] = useState(false);
    const [activeContent, setActiveContent] = useState(null); // Keep track of the active content

    const showSidebar = () => setSidebar(!sidebar);

    return (
        <>
            <IconContext.Provider value={{ color: '#fff' }}>
                <Nav>
                    <NavIcon to="#">
                        <FaIcons.FaBars onClick={showSidebar} />
                    </NavIcon>
                </Nav>

                <SidebarNav sidebar={sidebar}>
                    <SidebarWrap>
                        <NavIcon to="#">
                            <AiIcons.AiOutlineClose onClick={showSidebar} />
                        </NavIcon>
                        {MaterialSideBarData.map((item, index) => (
                            <SubMenu
                                item={item}
                                key={index}
                                setActiveContent={setActiveContent} // Pass setActiveContent here
                            />
                        ))}
                    </SidebarWrap>
                </SidebarNav>

                <ContentArea>

                    {activeContent && (
                        <>
                            <h1>{activeContent.title}</h1>
                            <MaterialTable materialTypeId={activeContent.materialTypeId} />
                        </>
                    )}
                </ContentArea>
            </IconContext.Provider>
        </>
    );
};

export default MaterialSideBar;
