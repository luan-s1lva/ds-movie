import './style.css'

function Navbar() {
    return(
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>
                        DSMovie
                    </h1>

                    <a href="https://gitlab.com/luan.carmo">
                        <div className='dsmovie-contact-container'>
                            <p className='link-gitlab'>
                                Gitlab.com/luan.carmo
                            </p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    )
}

export default Navbar;